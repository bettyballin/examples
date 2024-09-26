import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

public class Temp2512 {
    public static void main(String[] args) {
        try {
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            factory.setAttribute("http://xml.org/sax/features/external-general-entities", true);
            factory.setAttribute("http://apache.org/xml/features/security/entity-expansion-limit", 150);

            DocumentBuilder builder = factory.newDocumentBuilder();
            // Further processing with the builder if necessary

        } catch (ParserConfigurationException e) {
            e.printStackTrace();
        }
    }
}