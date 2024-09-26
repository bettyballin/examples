import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import javax.xml.XMLConstants;

public class SecureSAXParser {
    public static void main(String[] args) {
        try {
            SAXParserFactory spf = SAXParserFactory.newInstance();
            spf.setFeature(XMLConstants.FEATURE_SECURE_PROCESSING, true);
            spf.setFeature("http://apache.org/xml/features/disallow-doctype-decl", true);
            SAXParser saxParser = spf.newSAXParser();
            // Continue with saxParser usage...
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}