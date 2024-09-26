xml
<beans xmlns="http://www.springframework.org/schema/beans"
       xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
       xmlns:sec="http://www.springframework.org/schema/security"
       xsi:schemaLocation="http://www.springframework.org/schema/beans
           http://www.springframework.org/schema/beans/spring-beans.xsd
           http://www.springframework.org/schema/security
           http://www.springframework.org/schema/security/spring-security.xsd">

  <sec:authentication-manager alias="authenticationManager">
    <sec:authentication-provider ref="daoAuthenticationProvider" />
  </sec:authentication-manager>

  <bean id="daoAuthenticationProvider"
        class="org.springframework.security.authentication.dao.DaoAuthenticationProvider">
    <property name="userDetailsService" ref="userDetailsService"/>
    <property name="passwordEncoder" ref="passwordEncoder"/>
    <property name="preAuthenticationChecks">
      <bean class="com.example.NullUserDetailsChecker"/>
    </property>
    <property name="postAuthenticationChecks">
      <bean class="org.springframework.security.authentication.AccountStatusUserDetailsChecker"/>
    </property>
  </bean>

  <!-- Mock beans for userDetailsService and passwordEncoder -->
  <bean id="userDetailsService" class="org.springframework.security.core.userdetails.UserDetailsService">
    <qualifier value="userDetailsService"/>
  </bean>

  <bean id="passwordEncoder" class="org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder">
    <qualifier value="passwordEncoder"/>
  </bean>

</beans>