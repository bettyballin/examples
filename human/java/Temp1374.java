xml
<beans xmlns="http://www.springframework.org/schema/beans"
       xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
       xsi:schemaLocation="http://www.springframework.org/schema/beans 
       http://www.springframework.org/schema/beans/spring-beans.xsd">

    <bean id="encoder" class="org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder"/>

    <bean id="authenticationProvider" class="com.setelog.spring.handler.LimitLoginAuthenticationProvider">
        <property name="userDetailsService" ref="customUserDetailsService" />
        <property name="userDetailsDao" ref="userDetailsDao" />
        <property name="passwordEncoder" ref="encoder" />
    </bean>

</beans>