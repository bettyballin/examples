import org.xml.sax.EntityResolver;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;
import org.xml.sax.XMLReader;
import org.xml.sax.helpers.XMLReaderFactory;

import java.io.ByteArrayInputStream;
import java.io.IOException;

public class CustomEntityResolver implements EntityResolver {
    @Override
    public InputSource resolveEntity(String publicId, String systemId) throws SAXException, IOException {
        // Return an empty input source to ignore external entities and stylesheets
        return new InputSource(new ByteArrayInputStream("".getBytes()));
    }

    public static void main(String[] args) {
        try {
            XMLReader parser = XMLReaderFactory.createXMLReader();
            parser.setEntityResolver(new CustomEntityResolver());
            // Use the parser to parse an XML document here
        } catch (SAXException e) {
            e.printStackTrace();
        }
    }
}