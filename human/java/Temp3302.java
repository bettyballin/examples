import java.io.StringReader;
import javax.xml.stream.XMLInputFactory;
import javax.xml.stream.XMLStreamReader;
import javax.xml.transform.stream.StreamSource;

public class Temp3302 {
    public static void main(String[] args) {
        String manifestString = "<root><element>value</element></root>";
        XMLInputFactory xif = XMLInputFactory.newInstance();
        try {
            StringReader manifestReader = new StringReader(manifestString);
            XMLStreamReader xsr = xif.createXMLStreamReader(new StreamSource(manifestReader));
            while (xsr.hasNext()) {
                xsr.next();
                if (xsr.isStartElement()) {
                    System.out.println("Start Element: " + xsr.getLocalName());
                } else if (xsr.isEndElement()) {
                    System.out.println("End Element: " + xsr.getLocalName());
                } else if (xsr.hasText() && xsr.getText().trim().length() > 0) {
                    System.out.println("Text: " + xsr.getText().trim());
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}