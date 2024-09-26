xml
<beans xmlns="http://www.springframework.org/schema/beans"
       xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
       xsi:schemaLocation="http://www.springframework.org/schema/beans 
           http://www.springframework.org/schema/beans/spring-beans.xsd">

    <bean id="authenticationManager" class="org.springframework.security.authentication.ProviderManager">
        <property name="providers">
            <list>
                <ref bean="authenticationProvider" />
                <ref bean="anonymousProvider" />
            </list>
        </property>
    </bean>

    <bean id="authenticationProvider" class="org.springframework.security.authentication.dao.DaoAuthenticationProvider">
        <property name="passwordEncoder">
            <bean class="org.springframework.security.crypto.password.MessageDigestPasswordEncoder">
                <constructor-arg value="MD5" />
            </bean>
        </property>
        <property name="userDetailsService" ref="userService" />
    </bean>

    <bean id="anonymousProvider" class="org.springframework.security.authentication.AnonymousAuthenticationProvider">
        <property name="key" value="SomeUniqueKeyForThisApplication" />
    </bean>

    <!-- Define userService bean here -->
    <!-- Example: -->
    <!--
    <bean id="userService" class="com.example.UserService" />
    -->

</beans>