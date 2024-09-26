xml
<beans xmlns="http://www.springframework.org/schema/beans"
       xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
       xsi:schemaLocation="http://www.springframework.org/schema/beans
       http://www.springframework.org/schema/beans/spring-beans.xsd">

    <bean id="webServiceTemplate" class="org.springframework.ws.client.core.WebServiceTemplate">
        <property name="messageFactory" ref="poxMessageFactory" />
    </bean>    

    <bean id="poxMessageFactory" class="org.springframework.ws.pox.dom.DomPoxMessageFactory" />

</beans>