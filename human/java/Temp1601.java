xml
<?xml version="1.0" encoding="UTF-8"?>
<beans xmlns="http://www.springframework.org/schema/beans"
    xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance" xmlns:oauth="http://www.springframework.org/schema/security/oauth2"
    xmlns:security="http://www.springframework.org/schema/security"
    xsi:schemaLocation="http://www.springframework.org/schema/security/oauth2 
                    http://www.springframework.org/schema/security/spring-security-oauth2-2.0.xsd
                    http://www.springframework.org/schema/beans
                    http://www.springframework.org/schema/beans/spring-beans.xsd
                    http://www.springframework.org/schema/security
                    http://www.springframework.org/schema/security/spring-security-3.2.xsd">


    <http pattern="/oauth/token" create-session="stateless"
        authentication-manager-ref="clientAuthenticationManager"
        xmlns="http://www.springframework.org/schema/security">
        <intercept-url pattern="/oauth/token" access="IS_AUTHENTICATED_FULLY" />
        <anonymous enabled="false" />
        <http-basic entry-point-ref="clientAuthenticationEntryPoint" />
        <custom-filter ref="clientCredentialsTokenEndpointFilter"
            after="BASIC_AUTH_FILTER" />
        <access-denied-handler ref="oauthAccessDeniedHandler" />
    </http>

    <!-- The OAuth2 protected resources are separated out into their own block 
        so we can deal with authorization and error handling separately. This isn't 
        mandatory, but it makes it easier to control the behaviour. -->
    <http pattern="/test/*" create-session="never"
        entry-point-ref="oauthAuthenticationEntryPoint"
        access-decision-manager-ref="accessDecisionManager"
        xmlns="http://www.springframework.org/schema/security">
        <anonymous enabled="false" />
        <intercept-url pattern="/test/*" access="ROLE_USER" />
        <custom-filter ref="resourceServerFilter" before="PRE_AUTH_FILTER" />
        <access-denied-handler ref="oauthAccessDeniedHandler" />
    </http>

    <bean id="oauthAuthenticationEntryPoint"
        class="org.springframework.security.oauth2.provider.error.OAuth2AuthenticationEntryPoint">
        <property name="realmName" value="test" />
    </bean>

    <bean id="clientAuthenticationEntryPoint"
        class="org.springframework.security.oauth2.provider.error.OAuth2AuthenticationEntryPoint">
        <property name="realmName" value="test/client" />
        <property name="typeName" value="Basic" />
    </bean>

    <bean id="oauthAccessDeniedHandler"
        class="org.springframework.security.oauth2.provider.error.OAuth2AccessDeniedHandler" />

    <bean id="clientCredentialsTokenEndpointFilter"
        class="org.springframework.security.oauth2.provider.client.ClientCredentialsTokenEndpointFilter">
        <property name="authenticationManager" ref="clientAuthenticationManager" />
    </bean>

    <bean id="accessDecisionManager" class="org.springframework.security.access.vote.UnanimousBased"
        xmlns="http://www.springframework.org/schema/beans">
        <constructor-arg>
            <list>
                <bean class="org.springframework.security.oauth2.provider.vote.ScopeVoter" />
                <bean class="org.springframework.security.access.vote.RoleVoter" />
                <bean class="org.springframework.security.access.vote.AuthenticatedVoter" />
            </list>
        </constructor-arg>
    </bean>

    <authentication-manager id="clientAuthenticationManager"
        xmlns="http://www.springframework.org/schema/security">
        <authentication-provider user-service-ref="clientDetailsUserService" />
    </authentication-manager>

    <authentication-manager alias="authenticationManager"
        xmlns="http://www.springframework.org/schema/security">
        <authentication-provider>
            <user-service id="userDetailsService">
                <user name="user" password="password" authorities="ROLE_USER" />
            </user-service>
        </authentication-provider>
    </authentication-manager>

    <bean id="clientDetailsUserService"
        class="org.springframework.security.oauth2.provider.client.ClientDetailsUserDetailsService">
        <constructor-arg ref="clientDetails" />
    </bean>

    <!-- Used for the persistence of tokens (currently an in memory implementation) -->
    <bean id="tokenStore"
        class="org.springframework.security.oauth2.provider.token.store.InMemoryTokenStore" />

    <bean id="tokenServices"
        class="org.springframework.security.oauth2.provider.token.DefaultTokenServices">
        <property name="tokenStore" ref="tokenStore" />
        <property name="supportRefreshToken" value="true" />
        <property name="clientDetailsService" ref="clientDetails" />
    </bean>

    <bean id="userApprovalHandler"
        class="org.springframework.security.oauth2.provider.approval.DefaultUserApprovalHandler">
    </bean>

    <