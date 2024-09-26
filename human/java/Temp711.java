xml
<bean id="logoutFilter" class="org.springframework.security.web.authentication.logout.LogoutFilter">
    <constructor-arg ref="logoutSuccessHandler"/>
    <constructor-arg ref="logoutHandlers"/>
</bean>

<bean id="logoutSuccessHandler" class="your.custom.LogoutSuccessHandler"/>

<bean id="logoutHandlers" class="java.util.Arrays" factory-method="asList">
    <constructor-arg>
        <array>
            <bean class="your.custom.LogoutHandler"/>
        </array>
    </constructor-arg>
</bean>