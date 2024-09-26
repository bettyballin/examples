xml
<beans:beans xmlns="http://www.springframework.org/schema/security"
    xmlns:beans="http://www.springframework.org/schema/beans"
    xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
    xsi:schemaLocation="
        http://www.springframework.org/schema/security http://www.springframework.org/schema/security/spring-security-5.4.xsd
        http://www.springframework.org/schema/beans http://www.springframework.org/schema/beans/spring-beans.xsd">

    <http use-expressions="true">
        <intercept-url pattern="/login*" access="permitAll"/>
        <intercept-url pattern="/**" access="isAuthenticated()"/>

        <form-login
            authentication-success-handler-ref="refererAuthenticationSuccessHandler"
            />

        <logout/>
    </http>

    <!-- Route users to their profiles and admins to the admin console: -->
    <beans:bean id="authenticationSuccessHandler" class="a.b.c.AuthenticationSuccessHandler"/>

    <!-- Route to the originally requested page -->
    <beans:bean id="refererAuthenticationSuccessHandler" class="org.springframework.security.web.authentication.SimpleUrlAuthenticationSuccessHandler">
        <property name="useReferer" value="true"/>
    </beans:bean>

</beans:beans>