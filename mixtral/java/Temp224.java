import org.xml.sax.InputSource;
import org.xml.sax.XMLReader;
import org.xml.sax.helpers.XMLReaderFactory;

import java.io.ByteArrayInputStream;
import java.io.InputStream;

public class Temp224 {
    public static void main(String[] args) {
        try {
            String xmlContent = "<root></root>"; // Example XML content
            byte[] myByteArray = xmlContent.getBytes();

            InputStream input = new ByteArrayInputStream(myByteArray);
            InputSource source = new InputSource(input);

            XMLReader xmlReader = XMLReaderFactory.createXMLReader();
            xmlReader.parse(source);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}