xml
<beans xmlns="http://www.springframework.org/schema/beans"
       xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
       xmlns:security="http://www.springframework.org/schema/security"
       xsi:schemaLocation="
           http://www.springframework.org/schema/beans 
           http://www.springframework.org/schema/beans/spring-beans.xsd
           http://www.springframework.org/schema/security 
           http://www.springframework.org/schema/security/spring-security.xsd">

    <bean id="myUserDetailsService"
          class="complete.path.to.serviceClass.MyUserDetailsService"/>

    <bean id="passwordEncoder" 
          class="org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder"/>

    <security:authentication-manager>
        <security:authentication-provider user-service-ref="myUserDetailsService">
            <security:password-encoder ref="passwordEncoder"/>
        </security:authentication-provider>
    </security:authentication-manager>

</beans>