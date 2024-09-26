package com.perfectcomputersolutions.pos.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.reflect.CodeSignature;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import java.util.Objects;

@Aspect
@Order(0)
@Component
public class NoNullArgsAspect {

    @Before(
            value = "!execution(* *.getMetaClass(..)) && @within(com.perfectcomputersolutions.pos.annotation.NoNullArgs) || @annotation(com.perfectcomputersolutions.pos.annotation.NoNullArgs)"
    )
    public void requireNotNull(JoinPoint jp) {

        CodeSignature method = (CodeSignature) jp.getSignature();
        Class<?>[] types  = method.getParameterTypes();
        String[] names  = method.getParameterNames();
        Object[] args   = jp.getArgs();

        for (int i = 0; i < types.length; i++)
            Objects.requireNonNull(args[i], "Parameter " + names[i] + " must not be null");
    }
}