import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;
import org.aspectj.lang.reflect.MethodSignature;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import java.lang.reflect.Method;

@Component
@Aspect
public class IpRestrictionAspect {

    private static final Logger LOGGER = LoggerFactory.getLogger(IpRestrictionAspect.class);

    @Around("@annotation(com.example.IpRestricted)")
    public Object checkIp(ProceedingJoinPoint joinPoint) throws Throwable {
        MethodSignature signature = (MethodSignature) joinPoint.getSignature();
        Method method = signature.getMethod();

        IpRestricted ipRestrictedAnnotation = method.getAnnotation(IpRestricted.class);
        String[] allowedIps = ipRestrictedAnnotation.allowedIps();

        if (!isAllowedIp(allowedIps)) {
            String ipAddress = getIpAddress();
            LOGGER.error("Access denied for IP: {}", ipAddress);
            throw new RuntimeException("Access denied");
        }

        return joinPoint.proceed();
    }

    private boolean isAllowedIp(String[] allowedIps) {
        String ipAddress = getIpAddress();

        for (String ip : allowedIps) {
            if (ip.equalsIgnoreCase(ipAddress)) {
                return true;
            }
        }

        return false;
    }

    private String getIpAddress() {
        ServletRequestAttributes servletRequestAttributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        HttpServletRequest request = servletRequestAttributes.getRequest();
        return request.getRemoteAddr();
    }
}

// Example annotation interface
package com.example;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

@Retention(RetentionPolicy.RUNTIME)
public @interface IpRestricted {
    String[] allowedIps();
}