import javax.xml.parsers.SAXParserFactory;
import javax.xml.XMLConstants;

public class ParserExample {
    public static void main(String[] args) {
        try {
            SAXParserFactory spf = SAXParserFactory.newInstance();
            spf.setFeature(XMLConstants.FEATURE_SECURE_PROCESSING, true);
            // Continue with using the SAXParserFactory...
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}