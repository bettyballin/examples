xml
<beans xmlns="http://www.springframework.org/schema/beans"
    xmlns:security="http://www.springframework.org/schema/security"
    xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
    xmlns:c="http://www.springframework.org/schema/c"
    xsi:schemaLocation="http://www.springframework.org/schema/security http://www.springframework.org/schema/security/spring-security.xsd
    http://www.springframework.org/schema/beans http://www.springframework.org/schema/beans/spring-beans.xsd">

    <bean id="bCryptPasswordEncoder"
          class="org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder"
          c:strength="100"/>

    <security:authentication-manager>
        <security:authentication-provider
            user-service-ref="userDetailsServiceImpl">
            <security:password-encoder ref="bCryptPasswordEncoder" />
        </security:authentication-provider>
    </security:authentication-manager>

</beans>