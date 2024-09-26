xml
<?xml version="1.0" encoding="UTF-8"?>
<beans xmlns="http://www.springframework.org/schema/beans"
       xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
       xsi:schemaLocation="http://www.springframework.org/schema/beans 
       http://www.springframework.org/schema/beans/spring-beans.xsd">

    <bean id="ldapActiveDirectoryAuthProvider"
          class="org.springframework.security.ldap.authentication.ad.ActiveDirectoryLdapAuthenticationProvider">
        <constructor-arg value="company.local" />
        <constructor-arg value="ldap://servername.company.local" />
        <property name="searchFilter" value="customUserAttribute={0}" />
    </bean>

</beans>