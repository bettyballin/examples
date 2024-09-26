xml
<beans xmlns="http://www.springframework.org/schema/beans"
       xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
       xsi:schemaLocation="http://www.springframework.org/schema/beans
       http://www.springframework.org/schema/beans/spring-beans.xsd">

    <bean id="myDetailsService" class="com.company.service.impl.MyDetailsService"/>
    
    <bean id="myOtherService" class="com.company.service.impl.OtherService">
        <property name="detailsService" ref="myDetailsService"/>
    </bean>
    
</beans>