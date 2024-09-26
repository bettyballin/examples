import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

public class Temp502 {
    public static void main(String[] args) {
        try {
            DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
            dbf.setFeature("http://apache.org/xml/features/disallow-doctype-decl", true);
            System.out.println("Feature set successfully.");
        } catch (ParserConfigurationException | AbstractMethodError e) {
            e.printStackTrace();
        }
    }
}