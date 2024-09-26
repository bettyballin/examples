xml
<?xml version="1.0" encoding="UTF-8"?>

<beans xmlns="http://www.springframework.org/schema/beans"
       xmlns:security="http://www.springframework.org/schema/security"
       xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
       xsi:schemaLocation="http://www.springframework.org/schema/beans
                           http://www.springframework.org/schema/beans/spring-beans-4.0.xsd
                           http://www.springframework.org/schema/security
                           http://www.springframework.org/schema/security/spring-security-4.0.xsd">
    <security:http context-repository-ref="securityContextRepository" >
         <!-- intercept-url and other security configuration here... -->
    </security:http>

    <bean id="securityContextRepository" class="xxx.security.impl.spring.ReloadUserPerRequestHttpSessionSecurityContextRepository" >
        <constructor-arg index="0" ref="userRepository"/>
    </bean>
</beans>