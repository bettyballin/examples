xml
<beans xmlns="http://www.springframework.org/schema/beans"
       xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
       xsi:schemaLocation="http://www.springframework.org/schema/beans 
       http://www.springframework.org/schema/beans/spring-beans.xsd">

    <bean class="org.springframework.beans.factory.config.PropertyPlaceholderConfigurer">
        <property name="location">
            <list>
                <value>/path/to/config.properties</value>
            </list>
        </property>
        <property name="ignoreUnresolvablePlaceholders" value="true"/>
    </bean>

    <bean id="myBean" class="com.example.MyBean">
        <property name="username" value="${usernameFromExternalPropFile}" />
        <property name="password" value="${passwordFromExternalPropFile}" />
    </bean>
</beans>