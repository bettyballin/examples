xml
<bean id="messageSource"   
    class="org.springframework.context.support.ResourceBundleMessageSource">  
    <property name="basenames">  
        <list>
            <value>myMessages</value>
        </list>
    </property>
</bean>