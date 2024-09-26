xml
<beans:beans xmlns:beans="http://www.springframework.org/schema/beans"
             xmlns:security="http://www.springframework.org/schema/security"
             xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
             xsi:schemaLocation="http://www.springframework.org/schema/beans
                                 http://www.springframework.org/schema/beans/spring-beans.xsd
                                 http://www.springframework.org/schema/security
                                 http://www.springframework.org/schema/security/spring-security.xsd">

    <security:authentication-manager alias="authenticationManager">
        <security:authentication-provider user-service-ref="authServiceImpl">
            <security:password-encoder ref="passwordEncoder"/>
        </security:authentication-provider>
    </security:authentication-manager>

    <beans:bean id="passwordEncoder" class="org.springframework.security.crypto.password.MessageDigestPasswordEncoder">
        <beans:constructor-arg value="MD5"/>
    </beans:bean>

</beans:beans>