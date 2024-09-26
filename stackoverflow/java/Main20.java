import javax.xml.parsers.SAXParserFactory;

public class Main20 {
    public static void main(String[] args) {
        try {
            SAXParserFactory spf = SAXParserFactory.newInstance();
            spf.setFeature("http://apache.org/xml/features/disallow-doctype-decl", true);
            // Further processing with spf
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}