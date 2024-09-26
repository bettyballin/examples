xml
<beans xmlns="http://www.springframework.org/schema/beans"
       xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
       xmlns:security="http://www.springframework.org/schema/security"
       xsi:schemaLocation="http://www.springframework.org/schema/beans
           http://www.springframework.org/schema/beans/spring-beans.xsd
           http://www.springframework.org/schema/security
           http://www.springframework.org/schema/security/spring-security.xsd">

    <bean id="kerbEntryPoint" class="org.springframework.security.extensions.kerberos.web.SpnegoEntryPoint" />

    <bean id="kerbAuthenticationProcessingFilter" class="org.springframework.security.extensions.kerberos.web.SpnegoAuthenticationProcessingFilter">
        <property name="authenticationManager" ref="authenticationManager" />
    </bean>

    <bean id="authenticationManager" class="org.springframework.security.authentication.ProviderManager">
        <constructor-arg>
            <list>
                <bean class="org.springframework.security.extensions.kerberos.KerberosAuthenticationProvider">
                    <property name="kerberosClient" ref="kerberosClient" />
                    <property name="userDetailsService" ref="userDetailsService" />
                </bean>
            </list>
        </constructor-arg>
    </bean>

    <bean id="kerberosClient" class="org.springframework.security.extensions.kerberos.client.sun.SunKerberosClient" />

    <bean id="userDetailsService" class="org.springframework.security.core.userdetails.UserDetailsService">
        <!-- Define your UserDetailsService implementation here -->
    </bean>

    <security:http entry-point-ref="kerbEntryPoint">
        <security:custom-filter position="BASIC_AUTH_FILTER" ref="kerbAuthenticationProcessingFilter" />
    </security:http>
</beans>