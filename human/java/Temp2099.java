xml
<beans xmlns="http://www.springframework.org/schema/beans"
       xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
       xsi:schemaLocation="http://www.springframework.org/schema/beans
                           http://www.springframework.org/schema/beans/spring-beans.xsd">

    <bean id="daoAuthenticationProvider" class="org.springframework.security.authentication.dao.DaoAuthenticationProvider">
        <property name="userDetailsService" ref="myUserDetailsService"/>
        <!-- if you encode or encrypt your password, then pass encoder-->
        <!-- <property name="passwordEncoder" ref="passwordEncoder"/> -->
    </bean>

</beans>