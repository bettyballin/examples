import javax.xml.parsers.SAXParserFactory;
import javax.xml.parsers.SAXParser;
import org.xml.sax.InputSource;
import org.xml.sax.XMLReader;
import java.io.ByteArrayInputStream;
import java.io.InputStream;
import javax.xml.XMLConstants;

public class Temp887 {
    public static void main(String[] args) {
        byte[] myByteArray = "<root><element>Sample</element></root>".getBytes(); // Sample XML data
        InputStream textReader = new ByteArrayInputStream(myByteArray);
        SAXParserFactory parserFactory = SAXParserFactory.newInstance();
        try {
            SAXParser saxParser = parserFactory.newSAXParser();
            XMLReader reader = saxParser.getXMLReader();
            reader.setFeature(XMLConstants.FEATURE_SECURE_PROCESSING, true);
            InputSource inputSource = new InputSource(textReader);
            reader.parse(inputSource);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}