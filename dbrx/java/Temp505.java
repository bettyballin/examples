import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import org.w3c.dom.Document;
import org.xml.sax.SAXException;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;

public class Temp505 {
    public static void main(String[] args) {
        DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
        try {
            // Disable DTDs (doctype declarations)
            dbf.setFeature("http://apache.org/xml/features/disallow-doctype-decl", true);
            // Ignore external entities and parameter entities
            dbf.setFeature("http://xml.org/sax/features/external-general-entities", false);
            dbf.setFeature("http://xml.org/sax/features/external-parameter-entities", false);
            // Disable loading of DTDs
            dbf.setFeature("http://apache.org/xml/features/nonvalidating/load-external-dtd", false);

            String datosXml = "<root></root>"; // Sample XML data, replace with actual data
            InputStream stream = new ByteArrayInputStream(datosXml.getBytes());
            DocumentBuilder db = dbf.newDocumentBuilder();
            Document doc = db.parse(stream);
            
            // Process the document here
            
        } catch (ParserConfigurationException | SAXException | IOException e) {
            e.printStackTrace();
        }
    }
}