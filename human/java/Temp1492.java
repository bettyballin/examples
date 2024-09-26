xml
<?xml version="1.0" encoding="UTF-8"?>
<beans:beans xmlns="http://www.springframework.org/schema/security"
    xmlns:beans="http://www.springframework.org/schema/beans" xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
    xmlns:p="http://www.springframework.org/schema/p"
    xsi:schemaLocation="http://www.springframework.org/schema/beans
    http://www.springframework.org/schema/beans/spring-beans-3.2.xsd
    http://www.springframework.org/schema/security
    http://www.springframework.org/schema/security/spring-security-3.2.xsd">


    <beans:bean id="successHandler"
        class="org.springframework.security.web.authentication.SavedRequestAwareAuthenticationSuccessHandler">
        <beans:property name="defaultTargetUrl" value="/App/Index" />
    </beans:bean>

    <beans:bean id="failureHandler"
        class="org.springframework.security.web.authentication.SimpleUrlAuthenticationFailureHandler">
        <beans:property name="defaultFailureUrl" value="/App/loginError" />
    </beans:bean>

    <beans:bean id="loginUrlAuthenticationEntryPoint"
        class="org.springframework.security.web.authentication.LoginUrlAuthenticationEntryPoint">
        <beans:property name="loginFormUrl" value="/App/Login" />
    </beans:bean>

    <beans:bean id="sessionRegistry"
        class="org.springframework.security.core.session.SessionRegistryImpl">
    </beans:bean>

    <beans:bean id="sas"
        class="org.springframework.security.web.authentication.session.ConcurrentSessionControlStrategy">
        <beans:constructor-arg name="sessionRegistry"
            ref="sessionRegistry" />
        <beans:property name="maximumSessions" value="1" />
    </beans:bean>

    <http auto-config="true" entry-point-ref="loginUrlAuthenticationEntryPoint">
        <intercept-url pattern="/Content/**" access="IS_AUTHENTICATED_ANONYMOUSLY" />
        <intercept-url pattern="/Desktop/New_Them/**" access="IS_AUTHENTICATED_ANONYMOUSLY" />
        <intercept-url pattern="/App/Index" access="ROLE_USER" />
        <intercept-url pattern="/App/**" access="IS_AUTHENTICATED_ANONYMOUSLY" />
        <intercept-url pattern="/rest/clc/ClcLogPhon/**" access="IS_AUTHENTICATED_ANONYMOUSLY" />
        <intercept-url pattern="/**" access="ROLE_USER" />
        <custom-filter ref="concurrencyFilter" position="CONCURRENT_SESSION_FILTER" />
        <logout logout-success-url="/App/Login" />
        <remember-me key="myAppKey" />
        <session-management
            session-authentication-strategy-ref="sas">
        </session-management>
        <csrf />
        <headers>
            <xss-protection />
        </headers>
    </http>
    <global-method-security pre-post-annotations="enabled"
        secured-annotations="enabled" proxy-target-class="true" />

    <beans:bean id="concurrencyFilter"
        class="org.springframework.security.web.session.ConcurrentSessionFilter">
        <beans:property name="sessionRegistry" ref="sessionRegistry" />
        <beans:property name="expiredUrl" value="/App/Login" />
    </beans:bean>

    <beans:bean id="passwordEncoder"
        class="org.springframework.security.authentication.encoding.ShaPasswordEncoder">
        <beans:constructor-arg index="0" value="256" />
    </beans:bean>

    <beans:bean id="contextSource"
        class="org.springframework.security.ldap.DefaultSpringSecurityContextSource">
        <beans:constructor-arg
            value="ldap://192.168.1.143:389/DC=myDomain,DC=org" />
        <beans:property name="userDn"
            value="CN=username,CN=Users,DC=myDomain,DC=org" />
        <beans:property name="password" value="password" />
    </beans:bean>

    <beans:bean id="ldapAuthProvider"
        class="org.springframework.security.ldap.authentication.LdapAuthenticationProvider">
        <beans:constructor-arg>
            <beans:bean
                class="org.springframework.security.ldap.authentication.BindAuthenticator">
                <beans:constructor-arg ref="contextSource" />
                <beans:property name="userDnPatterns">
                    <beans:list>
                        <beans:value>uid={0},ou=users</beans:value>
                    </beans:list>
                </beans:property>
            </beans:bean>
        </beans:constructor-arg>
        <beans:constructor-arg>
            <beans:bean
                class="org.springframework.security.ldap.userdetails.DefaultLdapAuthoritiesPop