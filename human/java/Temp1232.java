xml
<beans xmlns="http://www.springframework.org/schema/beans"
       xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
       xmlns:security="http://www.springframework.org/schema/security"
       xsi:schemaLocation="http://www.springframework.org/schema/beans 
           http://www.springframework.org/schema/beans/spring-beans.xsd
           http://www.springframework.org/schema/security 
           http://www.springframework.org/schema/security/spring-security.xsd">

    <security:authentication-manager alias="authenticationManager">
        <security:authentication-provider ref="userLoginAuthenticationProvider" />
        <security:authentication-provider ref="groupLoginAuthenticationProvider" />
    </security:authentication-manager>

    <!-- user login -->
    <bean id="userLoginAuthenticationProvider"
          class="org.springframework.security.authentication.dao.DaoAuthenticationProvider">
        <property name="userDetailsService" ref="LoginServiceImpl"/>
        <property name="passwordEncoder" ref="encoder"/>
    </bean>

    <!-- group login -->
    <bean id="groupLoginAuthenticationProvider"
          class="org.springframework.security.authentication.dao.DaoAuthenticationProvider">
        <property name="userDetailsService" ref="GroupLoginServiceImpl"/>
        <property name="passwordEncoder" ref="encoder"/>
    </bean>

</beans>