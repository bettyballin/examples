import javax.xml.parsers.*;
import org.w3c.dom.*;
import org.xml.sax.SAXException;
import java.io.ByteArrayInputStream;
import java.io.IOException;

public class Temp219 {
    public static void main(String[] args) {
        // Sample XML content as a byte array
        String xmlContent = "<root><element>Sample</element></root>";
        byte[] myByteArray = xmlContent.getBytes();
        
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        factory.setNamespaceAware(true);
        
        try {
            DocumentBuilder builder = factory.newDocumentBuilder();
            ByteArrayInputStream input = new ByteArrayInputStream(myByteArray);
            
            Document doc = builder.parse(input);
            // Process the Document as needed
            System.out.println("Root element: " + doc.getDocumentElement().getNodeName());
        } catch (ParserConfigurationException | SAXException | IOException e) {
            e.printStackTrace();
        }
    }
}