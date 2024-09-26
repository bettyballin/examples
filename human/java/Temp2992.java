xml
<?xml version="1.0" encoding="UTF-8"?>
<b:beans xmlns="http://www.springframework.org/schema/security"
    xmlns:b="http://www.springframework.org/schema/beans"
    xmlns:p="http://www.springframework.org/schema/p"
    xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
    xmlns:context="http://www.springframework.org/schema/context"
    xsi:schemaLocation="http://www.springframework.org/schema/beans 
                        https://www.springframework.org/schema/beans/spring-beans.xsd
                        http://www.springframework.org/schema/context
                        http://www.springframework.org/schema/context/spring-context.xsd
                        http://www.springframework.org/schema/security 
                        https://www.springframework.org/schema/security/spring-security.xsd">   
    <context:component-scan
        base-package="com.mcnc.example.config" />   
    <http auto-config="true">
        <intercept-url pattern="/login" access="permitAll" />
        <intercept-url pattern="/public/**" access="permitAll" />
        <intercept-url pattern="/board/**"
            access="hasRole('ROLE_ADMIN')" />
        <form-login default-target-url="/board" />      
        <remember-me key="uniqueAndSecret" />
        <csrf token-repository-ref="tokenRepository" />
    </http>
    <b:bean id="tokenRepository"
        class="org.springframework.security.web.csrf.CookieCsrfTokenRepository"
        p:cookieHttpOnly="false" />
    <authentication-manager
        alias="authenticationManager">
        <authentication-provider
            user-service-ref="userDetailServiceImpl">
            <password-encoder ref="passwordEncoder"></password-encoder>
        </authentication-provider>
    </authentication-manager>
    <b:bean id="passwordEncoder" class="org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder">
        <b:constructor-arg name="strength" value="12"></b:constructor-arg>
    </b:bean>
</b:beans>