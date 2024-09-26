import javax.xml.parsers.*;
import org.w3c.dom.*;
import java.io.File;
import java.util.Base64;

public class XMLParser {
    public static void main(String[] args) {
        try {
            File fXmlFile = new File("path_to_your_file.xml");
            DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
            Document doc = dBuilder.parse(fXmlFile);
            doc.getDocumentElement().normalize();
            
            String modulusStr = doc.getElementsByTagName("Modulus").item(0).getTextContent();
            String exponentStr = doc.getElementsByTagName("Exponent").item(0).getTextContent();
            
            byte[] modulusBytes = Base64.getDecoder().decode(modulusStr);
            byte[] exponentBytes = Base64.getDecoder().decode(exponentStr);
            
            // Use modulusBytes and exponentBytes as needed
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}