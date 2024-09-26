import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MainApp {
    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("beans.xml");
        System.out.println("Spring context loaded.");
    }
}


xml
<?xml version="1.0" encoding="UTF-8"?>
<beans xmlns="http://www.springframework.org/schema/beans" xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
       xmlns:jaxws="http://cxf.apache.org/jaxws"
       xsi:schemaLocation="http://www.springframework.org/schema/beans http://www.springframework.org/schema/beans/spring-beans.xsd http://cxf.apache.org/jaxws http://cxf.apache.org/schemas/jaxws.xsd">

    <import resource="classpath:META-INF/cxf/cxf.xml"/>
    <import resource="classpath:META-INF/cxf/cxf-extension-soap.xml"/>
    <import resource="classpath:META-INF/cxf/cxf-servlet.xml"/>
    <import resource="classpath:META-INF/cxf/cxf-extension-policy.xml"/>
    <import resource="classpath:META-INF/cxf/cxf-extension-ws-security.xml"/>

    <bean id="implementorBean" class="ws.Implementor"/>

    <jaxws:endpoint id="implementor"
                    implementor="#implementorBean"
                    wsdlLocation="/ws/server/service.wsdl"
                    address="/service">

        <jaxws:inInterceptors>
            <bean class="ws.SpringSecurityInterceptor">
            </bean>
        </jaxws:inInterceptors>

        <jaxws:properties>
            <entry key="ws-security.signature.properties" value="/ws/security/server-crypto.properties"/>
            <entry key="ws-security.signature.username" value="serverkey"/>
            <entry key="ws-security.callback-handler" value="ws.ServerCallback"/>
        </jaxws:properties>

    </jaxws:endpoint>

</beans>



package ws;

public class Implementor {
    public String sayHello(String name) {
        return "Hello, " + name;
    }
}



package ws;

import org.apache.cxf.interceptor.AbstractPhaseInterceptor;
import org.apache.cxf.interceptor.Fault;
import org.apache.cxf.message.Message;

public class SpringSecurityInterceptor extends AbstractPhaseInterceptor<Message> {
    public SpringSecurityInterceptor() {
        super(org.apache.cxf.phase.Phase.PRE_INVOKE);
    }

    @Override
    public void handleMessage(Message message) throws Fault {
        // Handle security logic here
        System.out.println("Security Interceptor triggered");
    }
}



package ws;

import org.apache.wss4j.common.ext.WSPasswordCallback;

import javax.security.auth.callback.Callback;
import javax.security.auth.callback.CallbackHandler;
import javax.security.auth.callback.UnsupportedCallbackException;
import java.io.IOException;

public class ServerCallback implements CallbackHandler {
    public void handle(Callback[] callbacks) throws IOException, UnsupportedCallbackException {
        for (Callback callback : callbacks) {
            if (callback instanceof WSPasswordCallback) {
                WSPasswordCallback pc = (WSPasswordCallback) callback;
                if ("serverkey".equals(pc.getIdentifier())) {
                    pc.setPassword("password");
                }
            }
        }
    }
}


properties
# file: ws/security/server-crypto.properties
org.apache.ws.security.crypto.provider=org.apache.ws.security.components.crypto.Merlin
org.apache.ws.security.crypto.merlin.keystore.type=jks
org.apache.ws.security.crypto.merlin.file=server-keystore.jks
org.apache.ws.security.crypto.merlin.keystore.password=keystore-password


xml
<!-- Assume the WSDL file is located at ws/server/service.wsdl -->
<definitions xmlns="http://schemas.xmlsoap.org/wsdl/"
             xmlns:soap="http://schemas.xmlsoap.org/wsdl/soap/"
             xmlns:tns="http://ws/"
             targetNamespace="http://ws/"
             name="HelloService">

    <types>
        <xsd:schema xmlns:xsd="http://www.w3.org/2001/XMLSchema" targetNamespace="http://ws/">
            <xsd:element name="sayHello">
                <xsd:complexType>
                    <xsd:sequence>
                        <xsd:element name="name" type="xsd:string"/>
                    </xsd:sequence>
                </xsd:complexType>
            </xsd:element>
            <xsd:element name="sayHelloResponse">
                <xsd:complexType>
                    <xsd:sequence>
                        <xsd:element name="return" type="xsd:string"/>
                    </xsd:sequence>