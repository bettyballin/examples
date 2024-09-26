import org.xml.sax.SAXException;
import org.xml.sax.XMLReader;
import org.xml.sax.helpers.XMLReaderFactory;

public class XMLParserConfig {
    public static void main(String[] args) {
        try {
            XMLReader parser = XMLReaderFactory.createXMLReader();

            // Ignore external general entities
            parser.setFeature("http://xml.org/sax/features/external-general-entities", false);

            // Ignore external parameter entities
            parser.setFeature("http://xml.org/sax/features/external-parameter-entities", false);

            // Disable DTDs (Document Type Definitions) entirely
            parser.setFeature("http://apache.org/xml/features/nonvalidating/load-external-dtd", false);

            // Add your parsing logic here
            // ...

        } catch (SAXException e) {
            e.printStackTrace();
        }
    }
}