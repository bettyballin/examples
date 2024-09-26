xml
<beans xmlns="http://www.springframework.org/schema/beans"
       xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
       xmlns:sec="http://www.springframework.org/schema/security"
       xsi:schemaLocation="
           http://www.springframework.org/schema/beans
           http://www.springframework.org/schema/beans/spring-beans.xsd
           http://www.springframework.org/schema/security
           http://www.springframework.org/schema/security/spring-security.xsd">

    <bean id="myCustomUDS" class="com.myapp.AppUDS" />

    <sec:authentication-manager alias="authenticationManager">
        <sec:authentication-provider user-service-ref="myCustomUDS">
        </sec:authentication-provider>
    </sec:authentication-manager>

</beans>