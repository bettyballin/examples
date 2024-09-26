xml
<bean id="casAuthProvider" class="org.springframework.security.cas.authentication.CasAuthenticationProvider">
    <property name="ticketValidator" ref="ticketValidator"/>
    <property name="serviceProperties" ref="serviceProperties"/>
    <property name="authenticationUserDetailsService">
        <bean class="org.springframework.security.core.userdetails.UserDetailsByNameServiceWrapper">
            <constructor-arg ref="userService" />
        </bean>
    </property>
</bean>