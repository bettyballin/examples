xml
<beans xmlns="http://www.springframework.org/schema/beans"
       xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
       xmlns:security="http://www.springframework.org/schema/security"
       xsi:schemaLocation="http://www.springframework.org/schema/beans 
           http://www.springframework.org/schema/beans/spring-beans.xsd
           http://www.springframework.org/schema/security 
           http://www.springframework.org/schema/security/spring-security.xsd">

    <bean id="bCryptPasswordEncoder"
          class="org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder">
        <constructor-arg value="10"/>
    </bean>

    <security:authentication-manager>
        <security:authentication-provider user-service-ref="userDetailsServiceImpl">
            <security:password-encoder ref="bCryptPasswordEncoder"/>
        </security:authentication-provider>
    </security:authentication-manager>
</beans>