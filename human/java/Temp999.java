xml
<?xml version="1.0" encoding="UTF-8"?>
<beans xmlns="http://www.springframework.org/schema/beans"
   xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
   xmlns:security="http://www.springframework.org/schema/security"
   xsi:schemaLocation="http://www.springframework.org/schema/beans
   http://www.springframework.org/schema/beans/spring-beans.xsd
   http://www.springframework.org/schema/security
   http://www.springframework.org/schema/security/spring-security.xsd">

<security:http auto-config="true" use-expressions="true">
    <security:anonymous enabled="false"/>
    <security:form-login login-page="/login" default-target-url="/home"
                         login-processing-url="/j_spring_security_check"
                         authentication-failure-url="/loginfailed"/>
    <security:logout logout-success-url="/logout"/>
</security:http>

<bean id="adAuthenticationProvider"
      class="org.springframework.security.ldap.authentication.ad.ActiveDirectoryLdapAuthenticationProvider">
    <constructor-arg value="DOMAIN"/>
    <constructor-arg value="URL"/>
    <property name="convertSubErrorCodesToExceptions" value="true"/>
    <property name="useAuthenticationRequestCredentials" value="true"/>
</bean>

<bean id="customAuthenticationProvider"
      class="org.abbl.exhbp.templates.CustomAuthorityProvider">
    <constructor-arg ref="adAuthenticationProvider"/>
</bean>

<security:authentication-manager>
    <security:authentication-provider ref="customAuthenticationProvider"/>
</security:authentication-manager>

</beans>