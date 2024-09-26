xml
<beans xmlns="http://www.springframework.org/schema/beans"
       xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
       xsi:schemaLocation="http://www.springframework.org/schema/beans
       http://www.springframework.org/schema/beans/spring-beans.xsd">

    <bean id="absoluteUrlLoginFailureHandler" class="tld.company.AbsoluteUrlAuthenticationFailureHandler">
        <property name="defaultFailureUrl" value="http://company.domain.tld/Login.html"/>
    </bean>
    
    <bean id="absoluteUrlFilter" class="tld.company.MyUserPassFilter">
        <property name="authenticationFailureHandler" ref="absoluteUrlLoginFailureHandler"/>            
    </bean>

</beans>