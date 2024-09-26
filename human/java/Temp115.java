xml
<beans xmlns="http://www.springframework.org/schema/beans"
       xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
       xmlns:security="http://www.springframework.org/schema/security"
       xsi:schemaLocation="
           http://www.springframework.org/schema/beans
           http://www.springframework.org/schema/beans/spring-beans.xsd
           http://www.springframework.org/schema/security
           http://www.springframework.org/schema/security/spring-security.xsd">

    <security:global-method-security pre-post-annotations="enabled"/>

    <!-- HTTP security configurations -->
    <security:http auto-config="false" use-expressions="true" entry-point-ref="loginUrlAuthenticationEntryPoint">
        <security:access-denied-handler ref="myAccessDeniedHandler" />
        <!-- other configuration here -->
    </security:http>

    <!-- handler for authorization failure.  Will redirect to the login page. -->
    <bean id="myAccessDeniedHandler" class="org.springframework.security.web.access.AccessDeniedHandlerImpl">
        <property name="errorPage" value="/index" />
    </bean>

    <!-- Define the loginUrlAuthenticationEntryPoint bean -->
    <bean id="loginUrlAuthenticationEntryPoint" class="org.springframework.security.web.authentication.LoginUrlAuthenticationEntryPoint">
        <property name="loginFormUrl" value="/login" />
    </bean>
    
</beans>