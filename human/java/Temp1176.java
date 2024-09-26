package com.example.mymodule;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.FilterType;

@Configuration
@ComponentScan(basePackages = "com.example.mymodule",
        excludeFilters = @ComponentScan.Filter(type = FilterType.REGEX, pattern = "com.example.mymodule.*"))
public class Temp1176 {
    public static void main(String[] args) {
        // Application logic here
    }
}