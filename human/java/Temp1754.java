xml
<beans:beans xmlns:beans="http://www.springframework.org/schema/beans"
    xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance" 
    xmlns="http://www.springframework.org/schema/security"
    xsi:schemaLocation="http://www.springframework.org/schema/beans 
    http://www.springframework.org/schema/beans/spring-beans-3.0.xsd
    http://www.springframework.org/schema/security 
    http://www.springframework.org/schema/security/spring-security.xsd">

    <http auto-config="true" use-expressions="true">
        <intercept-url pattern="/sign/in" access="permitAll()" /> 
        <intercept-url pattern="/**" access="isAuthenticated()" />

        <form-login
            login-page="/sign/in"
            default-target-url="/secret/page"
            authentication-failure-url="/sign/in"
            password-parameter="password"
            username-parameter="username"
        />
    </http>

    <authentication-manager>
        <authentication-provider ref="customAuth"/>
    </authentication-manager>

    <beans:bean id="customAuth" class="xx.xxx.xxxx.CustomAuthenticationProvider" />
</beans:beans>