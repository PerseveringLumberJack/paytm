package com.example.paytmpayout.aspect;


import com.baomidou.mybatisplus.core.toolkit.SystemClock;
import com.example.paytmpayout.annotation.ControllerEndpoint;
import com.example.paytmpayout.service.OperationalLogService;
import com.example.paytmpayout.toolkit.ExceptionUtils;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import java.lang.reflect.Method;
import java.time.Instant;
import java.util.Objects;

@Slf4j
@Aspect
@Component
public class ControllerEndpointAspect extends BaseAspectSupport {

    @Autowired
    private OperationalLogService operationalLogService;

    @Around("pointcut()")
    public Object around(ProceedingJoinPoint point) {

        try {
            Long timeConsuming = SystemClock.now();
            Method targetMethod = resolveMethod(point);
            ControllerEndpoint annotation = targetMethod.getAnnotation(ControllerEndpoint.class);
            String operation = annotation.operation();
            Object result = point.proceed();
            if (StringUtils.isNoneBlank(operation)) {
                String ip = StringUtils.EMPTY;
                ServletRequestAttributes attributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
                if (Objects.nonNull(attributes)) {
                    ip = attributes.getRequest().getRemoteAddr();
                }
                operationalLogService.saveLog(point, targetMethod, ip, operation, "registrationToken", timeConsuming, result);
            }
            return result;
        } catch (Throwable throwable) {
            log.error("[保存数据异常]-THROWABLE提示：{}", throwable.getMessage());
        }
        return null;
    }

    @Pointcut("@annotation(com.example.paytmpayout.annotation.ControllerEndpoint)")
    public void pointcut() {
    }
}
