xml
<bean
    class="org.springframework.beans.factory.config.PropertyPlaceholderConfigurer">
    <property name="locations">
        <list>
            <value>classpath:config.properties</value>
        </list>
    </property>
</bean>

<bean class="org.springframework.beans.factory.config.MethodInvokingFactoryBean">
    <property name="staticMethod" value="com.setelog.spring.dao.UserDetailsDaoImpl.setEmails_Blocked"/>
    <property name="arguments">
        <list>
            <value>${emails_blocked}</value>
        </list>
    </property>
</bean>