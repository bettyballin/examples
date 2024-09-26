import oracle.xml.parser.v2.DOMParser;
import org.w3c.dom.Document;
import org.w3c.dom.NodeList;

import java.io.StringReader;

public class DomParserExample {
    public static void main(String[] args) throws Exception {

        String xmlPayload = "<?xml version=\"1.0\" encoding=\"UTF-8\"?>" +
                "<root></root>";

        DOMParser domParser = new DOMParser();
        // Disable external entity processing
        domParser.setFeature("http://apache.org/xml/features/disallow-doctype-decl", true);
        // Set a limit on expansion depth to avoid billion laughs attack
        domParser.setAttribute("DEFAULT_ENTITY_EXPANSION_DEPTH", "150");

        try {
            domParser.parse(new StringReader(xmlPayload));
            Document doc = domParser.getDocument();
            
            System.out.println("Root element: " + doc.getDocumentElement().getNodeName());
            NodeList nList = doc.getElementsByTagName("student");
        } catch (Exception e) {
            // Handle exceptions
            e.printStackTrace();
        }
    }
}