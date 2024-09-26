import javax.xml.stream.XMLInputFactory;
import javax.xml.stream.XMLStreamReader;
import javax.xml.transform.stream.StreamSource;
import java.io.StringReader;

public class Temp3303 {
    public static void main(String[] args) {
        String manifestString = "<root><element>Sample</element></root>"; // Example XML content
        XMLInputFactory xif = XMLInputFactory.newInstance();
        try {
            XMLStreamReader xsr = xif.createXMLStreamReader(new StreamSource(new StringReader(manifestString)));
            while (xsr.hasNext()) {
                xsr.next();
                if (xsr.isStartElement()) {
                    System.out.println("Start Element: " + xsr.getLocalName());
                } else if (xsr.isEndElement()) {
                    System.out.println("End Element: " + xsr.getLocalName());
                } else if (xsr.hasText() && xsr.getText().trim().length() > 0) {
                    System.out.println("Text: " + xsr.getText());
                }
            }
            xsr.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}