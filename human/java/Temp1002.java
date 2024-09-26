xml
<?xml version="1.0" encoding="UTF-8"?>
<beans xmlns="http://www.springframework.org/schema/beans"
       xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
       xmlns:security="http://www.springframework.org/schema/security"
       xsi:schemaLocation="http://www.springframework.org/schema/beans 
           http://www.springframework.org/schema/beans/spring-beans.xsd
           http://www.springframework.org/schema/security 
           http://www.springframework.org/schema/security/spring-security.xsd">

    <!-- Declare the user details for database check -->
    <bean id="userDetails" class="com.yourpackage.DatabaseUserDetails"/>

    <!-- Define provider -->
    <bean id="preauthAuthProvider" class="org.springframework.security.web.authentication.preauth.PreAuthenticatedAuthenticationProvider">
        <property name="preAuthenticatedUserDetailsService">
            <bean id="userDetailsServiceWrapper"
                  class="org.springframework.security.core.userdetails.UserDetailsByNameServiceWrapper">
                <property name="userDetailsService" ref="userDetails"/>
            </bean>
        </property>
    </bean>

    <!-- Define alias for the authentication manager -->
    <authentication-manager alias="authenticationManager">
        <security:authentication-provider ref="preauthAuthProvider"/>
    </authentication-manager>

    <!-- Declare the custom filter -->
    <bean id="authenticationFilter" class="com.yourpackage.AuthenticationFilter">
        <property name="authenticationManager" ref="authenticationManager"/>
    </bean>

    <security:http>
        <security:custom-filter ref="authenticationFilter" position="PRE_AUTH_FILTER"/>
    </security:http>

</beans>