xml
<bean id="ldapAuthenticationProvider" class="org.acegisecurity.providers.ldap.LdapAuthenticationProvider">
    <constructor-arg><ref bean="authenticator"/></constructor-arg>
    <constructor-arg><ref bean="populator"/></constructor-arg>
    <property name="userCache"><ref bean="userCache"/></property>
</bean>