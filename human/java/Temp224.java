xml
<?xml version="1.0" encoding="UTF-8"?>
<beans xmlns="http://www.springframework.org/schema/beans"
       xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
       xmlns:security="http://www.springframework.org/schema/security"
       xsi:schemaLocation="
           http://www.springframework.org/schema/beans
           http://www.springframework.org/schema/beans/spring-beans.xsd
           http://www.springframework.org/schema/security
           http://www.springframework.org/schema/security/spring-security.xsd">

    <security:authentication-manager>
        <security:authentication-provider ref="customAuthenticationProvider" />
    </security:authentication-manager>

    <bean id="customAuthenticationProvider" class="com.example.YourAuthenticationProvider">
        <property name="postAuthenticationChecks">
            <bean class="com.example.CustomPostAuthenticationChecks"/>
        </property>
    </bean>

</beans>