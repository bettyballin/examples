xml
<bean id="myFilter" 
    class="org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter">
    <property name="authenticationManager" ref="authenticationManager" />
    <property name="authenticationFailureHandler" ref="myAuthenticationSuccessHandler" />
    <property name="authenticationSuccessHandler" ref="myAuthenticationFailureHandler" />
</bean>

<bean id="myAuthenticationSuccessHandler" 
    class="my.MyAuthenticationSuccessHandler">
<!-- set properties here -->
</bean>

<!-- you can subclass this or one of its parents, too -->
<bean id="myAuthenticationFailureHandler" 
    class="org.springframework.security.web.authentication.ExceptionMappingAuthenticationFailureHandler">
    <!-- set properties such as exceptionMappings here -->
</bean>