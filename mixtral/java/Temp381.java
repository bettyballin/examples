import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

public class Temp381 {
    public static void main(String[] args) {
        try {
            SAXParserFactory factory = SAXParserFactory.newInstance();
            SAXParser parser = factory.newSAXParser();
            parser.setProperty("http://xml.org/sax/features/external-general-entities", false);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}