xml
<beans xmlns="http://www.springframework.org/schema/beans"
       xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
       xsi:schemaLocation="http://www.springframework.org/schema/beans
        http://www.springframework.org/schema/beans/spring-beans.xsd">

    <bean id="authenticationManager" class="org.acegisecurity.providers.ProviderManager">
        <property name="providers">
            <list>
                <ref bean="ldapAuthenticationProvider"/>
            </list>
        </property>
    </bean>

    <!-- Example bean definition for ldapAuthenticationProvider -->
    <bean id="ldapAuthenticationProvider" class="org.acegisecurity.providers.ldap.LdapAuthenticationProvider">
        <!-- Configuration properties for ldapAuthenticationProvider -->
    </bean>

</beans>