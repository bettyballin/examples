xml
<https:connector name="myHttpsConnector">
    <spring:property name="trustManagerFactory">
        <spring:bean class="com.mycompany.ssl.ExampleFactoryBean">
            <spring:property name="keystore" value="classpath:mykeystore.keystore" />
            <spring:property name="password" value="mypassword" />
        </spring:bean>
    </spring:property>
</https:connector>