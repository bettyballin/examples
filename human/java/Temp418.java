xml
<beans:beans xmlns="http://www.springframework.org/schema/security"
    xmlns:beans="http://www.springframework.org/schema/beans" xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
    xsi:schemaLocation="http://www.springframework.org/schema/beans
                        http://www.springframework.org/schema/beans/spring-beans-3.0.xsd
                        http://www.springframework.org/schema/security
                        http://www.springframework.org/schema/security/spring-security-3.0.4.xsd">

    <http access-denied-page="forms/error403.jsp" entry-point-ref="ntlmEntryPoint" servlet-api-provision="false"> 
        <intercept-url pattern="/**" access="ROLE_GUEST,ROLE_OPERATOR,ROLE_ADMIN" />
        <custom-filter position="PRE_AUTH_FILTER" ref="ntlmFilter"/>
    </http>

    <authentication-manager alias="mainAuthenticationManager">  
        <authentication-provider user-service-ref="userDetailsService" />
    </authentication-manager>

    <beans:bean id="userDetailsService" class="service.UserInfoService">
        <beans:property name="dataSource" ref="dataSource" />
        <beans:property name="usersByUsernameQuery" value="select distinct name, ' ' as password, 1 as enabled from TMP_SPRING_USERS where name=?" />
        <beans:property name="authoritiesByUsernameQuery" value="select name, role from TMP_SPRING_USERS where name=?" />
    </beans:bean>

    <beans:bean id="ntlmEntryPoint" class="org.springframework.security.ui.ntlm.NtlmAuthenticationFilterEntryPoint">
        <beans:property name="authenticationFailureUrl" value="forms/error403.html" />
    </beans:bean>

    <beans:bean id="ntlmFilter" class="org.springframework.security.ui.ntlm.NtlmAuthenticationFilter">
        <beans:property name="authenticationManager" ref="mainAuthenticationManager" />
        <beans:property name="retryOnAuthFailure" value="true" />
        <beans:property name="stripDomain" value="true"/>
        <beans:property name="domainController" value="company.com" />
        <beans:property name="jcifsProperties">
            <beans:props>
                <beans:prop key="jcifs.smb.lmCompatibility">0</beans:prop> 
                <beans:prop key="jcifs.smb.client.useExtendedSecurity">false</beans:prop> 
                <beans:prop key="jcifs.smb.client.domain">COMPANY</beans:prop>
                <beans:prop key="jcifs.smb.client.username">somenycuser</beans:prop>
                <beans:prop key="jcifs.smb.client.password">AReallyLoooongRandomPassword</beans:prop>
            </beans:props> 
        </beans:property> 
    </beans:bean>

</beans:beans>