package com.example.paytmpayout.aspect;

import com.example.paytmpayout.toolkit.ExceptionUtils;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.reflect.MethodSignature;

import java.lang.reflect.Method;
import java.util.Objects;

/**
 * <p>
 *
 * </p>
 *
 * @author BINGAI
 * @since 2021-08-12
 */

@Slf4j
public abstract class BaseAspectSupport {

    protected Method resolveMethod(ProceedingJoinPoint point) {
        Method method = null;
        try {
            MethodSignature signature = (MethodSignature) point.getSignature();
            Class<?> targetClass = point.getTarget().getClass();
            method = getDeclaredMethod(targetClass, signature.getName(), signature.getMethod().getParameterTypes());
            if (Objects.isNull(method)) {
                ExceptionUtils.throwException("无法解析目标方法:[" + signature.getMethod().getName() + "]");
            }
        } catch (Exception e) {
            log.error("[无法解析目标方法]-异常提示：{}", e.getMessage());
        }
        return method;
    }

    private Method getDeclaredMethod(Class<?> clazz, String name, Class<?>... parameterTypes) {
        try {
            return clazz.getDeclaredMethod(name, parameterTypes);
        } catch (NoSuchMethodException e) {
            Class<?> superClass = clazz.getSuperclass();
            if (Objects.nonNull(superClass)) {
                return getDeclaredMethod(superClass, name, parameterTypes);
            }
        }
        return null;
    }
}
