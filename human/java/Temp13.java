xml
<beans xmlns="http://www.springframework.org/schema/beans"
    xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
    xmlns:jaxws="http://cxf.apache.org/jaxws"
    xmlns:sec="http://cxf.apache.org/configuration/security"
    xmlns:http="http://cxf.apache.org/transports/http/configuration"
    xmlns:context="http://www.springframework.org/schema/context"
    xmlns:cxf="http://cxf.apache.org/core"
    xsi:schemaLocation="http://www.springframework.org/schema/beans
    http://www.springframework.org/schema/beans/spring-beans-2.5.xsd
    http://cxf.apache.org/configuration/security http://cxf.apache.org/schemas/configuration/security.xsd
    http://cxf.apache.org/transports/http/configuration http://cxf.apache.org/schemas/configuration/http-conf.xsd
    http://www.springframework.org/schema/context http://www.springframework.org/schema/context/spring-context-2.5.xsd
    http://cxf.apache.org/jaxws http://cxf.apache.org/schemas/jaxws.xsd
    http://cxf.apache.org/core http://cxf.apache.org/schemas/core.xsd">

    <context:property-placeholder location="meta/my.properties" />
    <context:component-scan base-package="com.foo" />

    <import resource="remoting.xml" />
    <jaxws:client id="myWebService" address="${my.endpointAddress}"
                  serviceClass="com.foo.my.ServicePortType">

<!-- Testing only, adds logging of entire message in and out -->
<jaxws:outInterceptors>
    <ref bean="TimestampUsernameToken_Request" />
    <ref bean="logOutbound" />
</jaxws:outInterceptors>
<jaxws:inInterceptors>
        <ref bean="logInbound" />
    </jaxws:inInterceptors>
    <jaxws:inFaultInterceptors>
        <ref bean="logOutbound" />
    </jaxws:inFaultInterceptors>

<!-- Production settings -->
<!--
    <jaxws:outInterceptors> <ref bean="TimestampUsernameToken_Request" />
    </jaxws:outInterceptors>
    -->
</jaxws:client>


<!--
    CXF Interceptors for Inbound and Outbound messages
    Used for logging and adding Username token / Timestamp Security Header to SOAP message
-->
<bean id="logInbound" class="org.apache.cxf.interceptor.LoggingInInterceptor" />
<bean id="logOutbound" class="org.apache.cxf.interceptor.LoggingOutInterceptor" />

<bean id="TimestampUsernameToken_Request" class="org.apache.cxf.ws.security.wss4j.WSS4JOutInterceptor">
    <constructor-arg>
        <map>
            <entry key="action" value="UsernameToken Timestamp" />
            <entry key="user" value="${my.group}.${my.userId}" />
            <entry key="passwordType" value="PasswordDigest" />
            <entry key="passwordCallbackClass" value="com.foo.my.ClientPasswordHandler" />
        </map>
    </constructor-arg>
</bean>

<!--
    http:conduit namespace is used to configure SSL using keystores, etc
    *.http-conduit works but CXF says its only supposed to be for temporary use (not production),
    well until the correct way works, we're going to use it.
-->
<http:conduit name="*.http-conduit">
    <http:tlsClientParameters   
                  secureSocketProtocol="SSL">
                  <!--
          <sec:trustManagers>
        <sec:keyStore type="JKS"
                         password="${my.truststore.password}"
                         file="${my.truststore.file}" />
                  </sec:trustManagers>
                  -->
                  <sec:keyManagers keyPassword="${my.keystore.password}">
                    <sec:keyStore type="JKS"
                         password="${my.keystore.password}"
                         file="${my.keystore.file}" />
                  </sec:keyManagers>

                  <!-- Cipher suites filters specify the cipher suite to allow/disallow in SSL communcation  -->
                  <sec:cipherSuitesFilter>
                    <sec:include>.*_WITH_3DES_.*</sec:include>
                    <sec:include>.*_EXPORT_.*</sec:include>
                    <sec:include>.*_EXPORT1024_.*</sec:include>
                    <sec:include>.*_WITH_DES_.*</sec:include>
                    <sec:exclude>.*_WITH_NULL_.*</sec:exclude>
                    <sec:exclude>.*_DH_anon_.*</sec:exclude>
                  </sec:cipherSuitesFilter>
    </http:tlsClientParameters>
</http:conduit>
</beans>