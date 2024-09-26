xml
<?xml version="1.0" encoding="UTF-8"?>
<beans xmlns="http://www.springframework.org/schema/beans"
       xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
       xmlns:context="http://www.springframework.org/schema/context"
       xmlns:sec="http://www.springframework.org/schema/security"
       xsi:schemaLocation="http://www.springframework.org/schema/beans http://www.springframework.org/schema/beans/spring-beans.xsd
                           http://www.springframework.org/schema/context http://www.springframework.org/schema/context/spring-context.xsd
                           http://www.springframework.org/schema/security http://www.springframework.org/schema/security/spring-security.xsd">

    <context:component-scan base-package="com.test.security" />

    <sec:http use-expressions="true">
        <sec:intercept-url pattern="/**" access="hasAnyRole('Admin','Data Operator','Data Collector')" />
        <sec:http-basic entry-point-ref="basicAuthenticationEntryPoint"/>
    </sec:http>

    <sec:authentication-manager alias="authenticationManager">
        <sec:authentication-provider user-service-ref="myAuthenticationProvider">
            <sec:password-encoder ref="encoder" />
        </sec:authentication-provider>
    </sec:authentication-manager>

    <bean id="myAuthenticationProvider" class="com.test.security.MyUserDetailsService" />

    <bean id="encoder" class="org.springframework.security.crypto.password.MessageDigestPasswordEncoder">
        <constructor-arg value="MD5" />
    </bean>

    <bean id="basicAuthenticationEntryPoint" class="com.test.MyAuthenticationEntryPoint" />

</beans>