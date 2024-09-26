import org.apache.axiom.om.OMAbstractFactory;
import org.apache.axiom.om.OMAttribute;
import org.apache.axiom.om.OMElement;
import org.apache.axiom.om.OMFactory;
import org.apache.axiom.om.OMNamespace;
import org.apache.axiom.soap.SOAPFactory;
import org.apache.axiom.soap.SOAPHeader;
import org.apache.axiom.soap.SOAPHeaderBlock;
import org.apache.axiom.soap.impl.factory.SOAP12Factory;

public class HeaderAdder {

    public static void addSecurityToHeader(SOAPHeader header) {

        OMFactory factory = OMAbstractFactory.getOMFactory();

        OMNamespace namespaceWSSE = factory
                .createOMNamespace(
                        "http://docs.oasis-open.org/wss/2004/01/oasis-200401-wss-wssecurity-secext-1.0.xsd",
                        "wsse");

        OMElement element = factory.createOMElement("Security", namespaceWSSE);

        OMAttribute attribute = factory.createOMAttribute("mustUnderstand",
                null, "1");

        element.addAttribute(attribute);

        header.addChild(element);

        OMElement element2 = factory.createOMElement("UsernameToken",
                namespaceWSSE);

        OMNamespace namespaceWSU = factory
                .createOMNamespace(
                        "http://docs.oasis-open.org/wss/2004/01/oasis-200401-wss-wssecurity-utility-1.0.xsd",
                        "wsu");

        attribute = factory.createOMAttribute("Id", namespaceWSU,
                "UsernameToken-1");

        element2.addAttribute(attribute);

        element.addChild(element2);

        OMElement element3 = factory.createOMElement("Username", namespaceWSSE);

        element3.setText("<YOUR USERNAME>");

        OMElement element4 = factory.createOMElement("Password", namespaceWSSE);

        attribute = factory
                .createOMAttribute(
                        "Type",
                        null,
                        "http://docs.oasis-open.org/wss/2004/01/oasis-200401-wss-username-token-profile-1.0#PasswordText");

        element4.setText("<YOUR PASSWORD>");

        element2.addChild(element3);
        element2.addChild(element4);
    }

    public static void main(String[] args) {
        SOAPFactory soapFactory = new SOAP12Factory();
        SOAPHeader header = soapFactory.createSOAPHeader();
        addSecurityToHeader(header);
        
        System.out.println(header);
    }
}


To execute this code, ensure you have Apache Axiom library in your classpath. You can add it using a build tool like Maven or Gradle.

Example Maven dependency:
xml
<dependency>
    <groupId>org.apache.ws.commons.axiom</groupId>
    <artifactId>axiom-api</artifactId>
    <version>1.2.22</version>
</dependency>
<dependency>
    <groupId>org.apache.ws.commons.axiom</groupId>
    <artifactId>axiom-impl</artifactId>
    <version>1.2.22</version>
</dependency>