import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.XMLConstants;

public class SecureXMLParser {
    public static void main(String[] args) {
        try {
            DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
            dbf.setFeature(XMLConstants.FEATURE_SECURE_PROCESSING, true);
            
            // Disable DTDs (Doctype Declaration):
            dbf.setFeature("http://apache.org/xml/features/disallow-doctype-decl", true);
            
            // Disable external entities:
            dbf.setFeature("http://xml.org/sax/features/external-general-entities", false);
            dbf.setFeature("http://xml.org/sax/features/external-parameter-entities", false);
            
            // Disable external DTDs as well:
            dbf.setFeature("http://apache.org/xml/features/nonvalidating/load-external-dtd", false);
            
            // Set other features to prevent XXE
            dbf.setXIncludeAware(false);
            dbf.setExpandEntityReferences(false);

            DocumentBuilder db = dbf.newDocumentBuilder();
            // Further processing with DocumentBuilder 'db'
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}