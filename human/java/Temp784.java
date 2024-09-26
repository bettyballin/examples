xml
<beans xmlns="http://www.springframework.org/schema/beans"
       xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
       xmlns:security="http://www.springframework.org/schema/security"
       xsi:schemaLocation="http://www.springframework.org/schema/beans
           http://www.springframework.org/schema/beans/spring-beans.xsd
           http://www.springframework.org/schema/security
           http://www.springframework.org/schema/security/spring-security.xsd">

    <security:global-method-security pre-post-annotations="enabled">
        <security:expression-handler ref="expressionHandler" />
    </security:global-method-security>

    <bean id="expressionHandler" class="org.springframework.security.access.expression.method.DefaultMethodSecurityExpressionHandler">
        <property name="permissionEvaluator" ref="customPermissionEvaluator" />
    </bean>

    <bean id="customPermissionEvaluator" class="com.example.CustomPermissionEvaluator" />
</beans>