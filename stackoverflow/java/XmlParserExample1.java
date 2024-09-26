import javax.xml.parsers.SAXParserFactory;
import javax.xml.XMLConstants;
import org.xml.sax.InputSource;
import org.xml.sax.XMLReader;
import java.io.ByteArrayInputStream;
import java.io.InputStream;

public class XmlParserExample1 {
    public static void main(String[] args) {
        byte[] myByteArray = "Your XML content here".getBytes();
        InputStream textReader = new ByteArrayInputStream(myByteArray);
        SAXParserFactory parserFactory = SAXParserFactory.newInstance();

        try {
            parserFactory.setFeature(XMLConstants.FEATURE_SECURE_PROCESSING, true);
            XMLReader reader = parserFactory.newSAXParser().getXMLReader();
            InputSource inputSource = new InputSource(textReader);
            reader.parse(inputSource);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}