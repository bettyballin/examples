xml
<beans xmlns="http://www.springframework.org/schema/beans"
       xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
       xmlns:context="http://www.springframework.org/schema/context"
       xsi:schemaLocation="http://www.springframework.org/schema/beans
           http://www.springframework.org/schema/beans/spring-beans.xsd
           http://www.springframework.org/schema/context
           http://www.springframework.org/schema/context/spring-context.xsd">

    <bean id="contextSource" class="org.springframework.security.ldap.DefaultSpringSecurityContextSource">
        <constructor-arg value="ldap://server:389/o=company,c=com"/>
        <property name="anonymousReadOnly" value="true"/>
    </bean>

    <bean id="ldapAuthProvider" class="org.springframework.security.ldap.authentication.LdapAuthenticationProvider">
        <constructor-arg>
            <bean class="org.springframework.security.ldap.authentication.BindAuthenticator">
                <constructor-arg ref="contextSource"/>
                <property name="userDnPatterns">
                    <list>
                        <value>uid={0},ou=Employees</value>
                        <value>uid={0},ou=Clients</value>
                    </list>
                </property>         
            </bean>
        </constructor-arg>
        <constructor-arg>
            <bean class="org.springframework.security.ldap.userdetails.DefaultLdapAuthoritiesPopulator">
                <constructor-arg ref="contextSource"/>
                <constructor-arg value=""/>
                <property name="searchSubtree" value="true"/>
                <property name="groupRoleAttribute" value="cn"/>
                <property name="groupSearchFilter" value="uniquemember={0}"/>   
            </bean>
        </constructor-arg>
    </bean>

</beans>