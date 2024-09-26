xml
<beans xmlns="http://www.springframework.org/schema/beans"
       xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
       xmlns:context="http://www.springframework.org/schema/context"
       xmlns:security="http://www.springframework.org/schema/security"
       xsi:schemaLocation="
           http://www.springframework.org/schema/beans http://www.springframework.org/schema/beans/spring-beans.xsd
           http://www.springframework.org/schema/context http://www.springframework.org/schema/context/spring-context.xsd
           http://www.springframework.org/schema/security http://www.springframework.org/schema/security/spring-security.xsd">

    <security:http use-expressions="true">
        <security:expression-handler ref="webExpressionHandler"/>
        <!-- Additional security configuration here -->
    </security:http>

    <beans:bean id="webExpressionHandler"
                class="org.springframework.security.web.access.expression.DefaultWebSecurityExpressionHandler">
        <beans:property name="permissionEvaluator" ref="permissionEvaluator"/>
    </beans:bean>

    <beans:bean id="permissionEvaluator" class="your.PermissionEvaluator"/>
    
</beans>