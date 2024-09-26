import org.opensaml.core.config.InitializationService;
import org.opensaml.saml.common.SAMLException;
import org.opensaml.saml.saml2.core.Assertion;
import org.opensaml.saml.saml2.core.Response;
import org.opensaml.saml.saml2.core.impl.AssertionUnmarshaller;
import org.opensaml.saml.saml2.core.impl.ResponseUnmarshaller;
import org.opensaml.xmlsec.signature.support.SignatureException;
import org.w3c.dom.Element;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.ByteArrayInputStream;

public class Temp3463 {
    public static void main(String[] args) {
        try {
            InitializationService.initialize();
            System.out.println("OpenSAML initialized successfully.");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}


To make this code executable, you also need to add the OpenSAML dependencies to your build system. Here is how you can do it with Maven:

xml
<dependencies>
    <dependency>
        <groupId>org.opensaml</groupId>
        <artifactId>opensaml-core</artifactId>
        <version>4.1.1</version>
    </dependency>
    <dependency>
        <groupId>org.opensaml</groupId>
        <artifactId>opensaml-saml-api</artifactId>
        <version>4.1.1</version>
    </dependency>
    <dependency>
        <groupId>org.opensaml</groupId>
        <artifactId>opensaml-saml-impl</artifactId>
        <version>4.1.1</version>
    </dependency>
</dependencies>


Or, if you are using Gradle:

groovy
dependencies {
    implementation 'org.opensaml:opensaml-core:4.1.1'
    implementation 'org.opensaml:opensaml-saml-api:4.1.1'
    implementation 'org.opensaml:opensaml-saml-impl:4.1.1'
}


Make sure to include the necessary repositories in your build configuration as well.