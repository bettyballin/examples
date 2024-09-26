import javax.xml.namespace.QName;
import com.sun.xml.ws.developer.WSBindingProvider;
import com.sun.xml.ws.api.message.Headers;
import javax.xml.bind.JAXBContext;
import javax.xml.ws.Service;
import javax.xml.ws.WebServiceRef;

public class Temp54 {

    @WebServiceRef
    private static HelloService helloService;

    public static void main(String[] args) {
        try {
            // Initialize the service and port
            helloService = new HelloService();
            HelloPort port = helloService.getHelloPort();

            // Cast port to WSBindingProvider
            WSBindingProvider bp = (WSBindingProvider) port;

            // Create JAXB context (assuming you have a MyJaxbObject class to marshal)
            JAXBContext jaxbContext = JAXBContext.newInstance(MyJaxbObject.class);
            MyJaxbObject myJaxbObject = new MyJaxbObject(); // initialize your JAXB object

            // Set outbound headers
            bp.setOutboundHeaders(
                // simple string value as a header
                Headers.create(new QName("simpleHeader"), "stringValue"),
                // create a header from JAXB object
                Headers.create(jaxbContext, myJaxbObject)
            );

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}


Note: This code assumes the existence of `HelloService`, `HelloPort`, and `MyJaxbObject` classes, which need to be defined elsewhere in your project.