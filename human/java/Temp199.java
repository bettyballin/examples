xml
<bean name="brandAwareFilterBean" class="com.drumpus.webapp.LoginVelocityCheckFilter">
    <property name="authenticationManager" ref="authenticationManager"/>
    <property name="filterProcessesUrl" value="/doLogin"/>
    <property name="authenticationSuccessHandler">
        <bean class="org.springframework.security.web.authentication.SavedRequestAwareAuthenticationSuccessHandler">
            <property name="defaultTargetUrl" value="/account/"/>
            <property name="alwaysUseDefaultTargetUrl" value="false"/>
        </bean>
    </property>
    <property name="authenticationFailureHandler">
        <bean class="org.springframework.security.web.authentication.SimpleUrlAuthenticationFailureHandler">
            <property name="defaultFailureUrl" value="/login?failed=true"/>
        </bean>
    </property>
</bean>


<security:http auto-config="false" use-expressions="true" entry-point-ref="authenticationEntryPoint">

    <security:custom-filter position="FORM_LOGIN_FILTER" ref="brandAwareFilterBean"/>

    <!-- the rest of your config -->

</security:http>