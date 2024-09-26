xml
<beans xmlns="http://www.springframework.org/schema/beans"
       xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
       xmlns:security="http://www.springframework.org/schema/security"
       xsi:schemaLocation="http://www.springframework.org/schema/beans 
           http://www.springframework.org/schema/beans/spring-beans.xsd
           http://www.springframework.org/schema/security 
           http://www.springframework.org/schema/security/spring-security.xsd">

    <security:authentication-manager>
        <security:authentication-provider>
            <security:password-encoder ref="encoder" />
        </security:authentication-provider>
    </security:authentication-manager>

    <bean id="encoder" class="org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder">
        <constructor-arg name="strength" value="15" />
    </bean>

</beans>