xml
<?xml version="1.0" encoding="UTF-8"?>
<beans xmlns="http://www.springframework.org/schema/beans"
    xmlns:sec="http://www.springframework.org/schema/security"
    xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
    xmlns:aop="http://www.springframework.org/schema/aop"
    xmlns:context="http://www.springframework.org/schema/context"
    xsi:schemaLocation="
        http://www.springframework.org/schema/aop http://www.springframework.org/schema/aop/spring-aop.xsd
        http://www.springframework.org/schema/context http://www.springframework.org/schema/context/spring-context.xsd
        http://www.springframework.org/schema/jee http://www.springframework.org/schema/jee/spring-jee.xsd
        http://www.springframework.org/schema/lang http://www.springframework.org/schema/lang/spring-lang.xsd
        http://www.springframework.org/schema/tx http://www.springframework.org/schema/tx/spring-tx.xsd
        http://www.springframework.org/schema/util http://www.springframework.org/schema/util/spring-util.xsd
        http://www.springframework.org/schema/mvc http://www.springframework.org/schema/mvc/spring-mvc-3.0.xsd
        http://www.springframework.org/schema/beans http://www.springframework.org/schema/beans/spring-beans-3.0.xsd
        http://www.springframework.org/schema/security http://www.springframework.org/schema/security/spring-security-3.1.xsd">

    <sec:global-method-security pre-post-annotations="enabled" />

    <sec:http pattern="/css/**" security="none"/>
    <sec:http pattern="/images/**" security="none"/>
    <sec:http pattern="/js/**" security="none"/>
    <sec:http pattern="/index.jsp" security="none"/>
    <!-- <sec:http pattern="/app/addNewUser.json" security="none"/> -->
    <sec:http pattern="/login.jsp" security="none"/>
    <sec:http use-expressions="true">
        <sec:intercept-url pattern="/**/referencemetadatahome*" access="hasRole('ROLE_ADMIN')" />
        <!--
             Allow all other requests. In a real application you should
             adopt a whitelisting approach where access is not allowed by default
          -->
        <sec:intercept-url pattern="/**" access="isAuthenticated()" />
        <sec:form-login login-page='/login.jsp'
          authentication-failure-url="/login.jsp?login_error=1"
          default-target-url="/index.jsp" />
        <sec:logout logout-success-url="/login.jsp" delete-cookies="JSESSIONID"/>
        <sec:remember-me />
    </sec:http>

    <bean id="myUserService" class="com.aa.ceg.proj.mars.serviceimpl.UserServiceImpl" />
    <sec:authentication-manager>
        <sec:authentication-provider user-service-ref="myUserService" />
    </sec:authentication-manager>
    <bean id="loggerListener" class="org.springframework.security.authentication.event.LoggerListener"/>
</beans>