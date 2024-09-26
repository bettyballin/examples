import org.apache.xerces.parsers.SAXParser;
import org.xml.sax.XMLReader;
import org.xml.sax.SAXException;

public class Temp308 {
    public static void main(String[] args) {
        try {
            final XMLReader parser = new SAXParser();

            parser.setFeature("http://xml.org/sax/features/external-general-entities", false);
            parser.setFeature("http://apache.org/xml/features/disallow-doctype-decl", true);

            System.out.println("Parser configured successfully.");
        } catch (SAXException e) {
            e.printStackTrace();
        }
    }
}