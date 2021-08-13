package com.example.paytmpayout.service.impl;

import com.baomidou.mybatisplus.core.toolkit.SystemClock;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.paytmpayout.convert.OperationalLogEntityTransfer;
import com.example.paytmpayout.entity.IOperationalLogEntity;

import com.example.paytmpayout.service.OperationalLogService;
import com.example.paytmpayout.utils.LocalVariableParametereDiscoverer;
import com.example.paytmpayout.utils.Strings;
import org.aspectj.lang.ProceedingJoinPoint;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.paytmpayout.repository.IOperationalLogRepository;
import java.lang.reflect.Method;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author BINGAI
 * @since 2021-08-12
 */
@Service
public class OperationalLogServiceImpl extends ServiceImpl<IOperationalLogRepository, IOperationalLogEntity> implements OperationalLogService {

    @Autowired
    private LocalVariableParametereDiscoverer parametereDiscoverer;

    @Override
    public Boolean saveLog(ProceedingJoinPoint point, Method method, String ip, String operation, String registrationToken, Long timeConsum,Object o) {

        String className = point.getTarget().getClass().getName();
        String methodName = method.getName();
        String operationalMethod = className+Strings.DOT + methodName + Strings.BRACKETS;
        String params = parametereDiscoverer.queryParams(method, point.getArgs());
        Long timeConsuming = SystemClock.now()-timeConsum;
        return saveOrUpdate(OperationalLogEntityTransfer.instance.convertOperationalLogEntity(operationalMethod,params,ip,operation,registrationToken,timeConsuming,o));
    }
}
