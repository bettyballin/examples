xml
<beans xmlns="http://www.springframework.org/schema/beans"
       xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
       xmlns:context="http://www.springframework.org/schema/context"
       xmlns:security="http://www.springframework.org/schema/security"
       xsi:schemaLocation="
           http://www.springframework.org/schema/beans http://www.springframework.org/schema/beans/spring-beans.xsd
           http://www.springframework.org/schema/context http://www.springframework.org/schema/context/spring-context.xsd
           http://www.springframework.org/schema/security http://www.springframework.org/schema/security/spring-security.xsd">

    <bean id="logoutFilter" class="org.springframework.security.web.authentication.logout.LogoutFilter">
        <constructor-arg index="0" value="/logoutSuccess" />
        <constructor-arg index="1">
            <list>
                <bean id="securityContextLogoutHandler"
                      class="org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler" />
                <bean id="myLogoutHandler" class="my.package.MyLogoutHandler" />
            </list>
        </constructor-arg>
        <property name="filterProcessesUrl" value="/logout" />
    </bean>

</beans>