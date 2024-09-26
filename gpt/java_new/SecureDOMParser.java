import oracle.xml.parser.v2.DOMParser;
import oracle.xml.parser.v2.XMLParser;
import oracle.xml.parser.v2.XMLDocument;

public class SecureDOMParser {
    public static void main(String[] args) {
        try {
            DOMParser domParser = new DOMParser();

            // Disable external entities
            domParser.setFeature(XMLParser.FEATURE_DISALLOW_DOCTYPE_DECL, true);
            domParser.setFeature("http://xml.org/sax/features/external-general-entities", false);
            domParser.setFeature("http://xml.org/sax/features/external-parameter-entities", false);

            // Optionally, if you can limit entity expansion to protect against entity expansion attacks
            // domParser.setProperty("http://apache.org/xml/properties/security-manager", new SecurityManager());

            // Parsing an XML Document
            // domParser.parse("path_to_xml_file");
            // XMLDocument document = domParser.getDocument();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}