xml
<beans xmlns="http://www.springframework.org/schema/beans"
       xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
       xmlns:oauth="http://www.springframework.org/schema/security/oauth2"
       xsi:schemaLocation="http://www.springframework.org/schema/beans
           http://www.springframework.org/schema/beans/spring-beans.xsd
           http://www.springframework.org/schema/security/oauth2
           http://www.springframework.org/schema/security/spring-security-oauth2.xsd">

    <bean id="fooClient" class="com.abc.service.ExtendedBaseOAuth2ProtectedResourceDetails">
        <property name="clientId" value="foo"/>
        <property name="clientSecret" value="secret"/>
        <property name="accessTokenUri" value="${accessTokenUri}"/>
        <property name="userAuthorizationUri" value="${userAuthorizationUri}"/>
        <property name="scope">
            <list>
                <value>read</value>
                <value>write</value>
            </list>
        </property>
    </bean>

    <bean id="dService" class="com.abc.service.DServiceImpl">
        <property name="dURL" value="${dURL}"/>
        <property name="dRestTemplate">
            <oauth:rest-template resource="fooClient" />
        </property>
    </bean>

</beans>