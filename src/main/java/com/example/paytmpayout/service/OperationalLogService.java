package com.example.paytmpayout.service;

import com.example.paytmpayout.entity.IOperationalLogEntity;
import com.baomidou.mybatisplus.extension.service.IService;
import org.aspectj.lang.ProceedingJoinPoint;

import java.lang.reflect.Method;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author BINGAI
 * @since 2021-08-12
 */
public interface OperationalLogService extends IService<IOperationalLogEntity> {


    Boolean saveLog(ProceedingJoinPoint point, Method method, String ip, String operation,String registrationToken,Long timeConsuming,Object object);
}
