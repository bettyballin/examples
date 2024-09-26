xml
<beans xmlns="http://www.springframework.org/schema/beans"
       xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
       xmlns:security="http://www.springframework.org/schema/security"
       xsi:schemaLocation="http://www.springframework.org/schema/beans
           http://www.springframework.org/schema/beans/spring-beans.xsd
           http://www.springframework.org/schema/security
           http://www.springframework.org/schema/security/spring-security.xsd">

    <bean id="customAuthenticationFailureHandler" class="org.springframework.security.web.authentication.ExceptionMappingAuthenticationFailureHandler">
        <property name="exceptionMappings">
            <props>
                <prop key="org.springframework.security.authentication.CredentialsExpiredException">/change_password_page</prop>
            </props>
        </property>
        <property name="defaultFailureUrl" value="/resetPassword"/>
    </bean>

</beans>