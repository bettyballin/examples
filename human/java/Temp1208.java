xml
<?xml version="1.0" encoding="UTF-8"?>
<beans xmlns="http://www.springframework.org/schema/beans"
   xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
   xmlns:security="http://www.springframework.org/schema/security"
   xmlns:oauth2="http://www.springframework.org/schema/security/oauth2"
   xsi:schemaLocation="
    http://www.springframework.org/schema/beans
    http://www.springframework.org/schema/beans/spring-beans-3.1.xsd
    http://www.springframework.org/schema/security
    http://www.springframework.org/schema/security/spring-security-3.1.xsd
    http://www.springframework.org/schema/security/oauth2
    http://www.springframework.org/schema/security/spring-security-oauth2.xsd">

    <bean id="tokenServices" class="com.example.security.oauth2.wso2.TokenServiceWSO2" />

    <bean id="authenticationEntryPoint" class="org.springframework.security.oauth2.provider.error.OAuth2AuthenticationEntryPoint" />

    <security:authentication-manager alias="authenticationManager" />

    <oauth2:resource-server id="resourcesServerFilter" token-services-ref="tokenServices" />

    <security:http pattern="/services/**" create-session="stateless" entry-point-ref="authenticationEntryPoint" >
        <security:anonymous enabled="false" />
        <security:custom-filter ref="resourcesServerFilter" before="PRE_AUTH_FILTER" />
        <security:intercept-url pattern="/services/**" access="IS_AUTHENTICATED_ANONYMOUSLY"/>
    </security:http>
</beans>