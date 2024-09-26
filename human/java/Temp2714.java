package com.perfectcomputersolutions.pos.annotation;

import org.springframework.stereotype.Component;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

public class Temp2714 {
    public static void main(String[] args) {
        // Example usage of the annotation (optional)
        System.out.println("Application running...");
    }

    @Component
    @Target({ElementType.METHOD, ElementType.TYPE})
    @Retention(RetentionPolicy.RUNTIME)
    public @interface NoNullArgs {
    }
}