import java.io.IOException;
import org.xml.sax.ContentHandler;
import org.xml.sax.DTDHandler;
import org.xml.sax.EntityResolver;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;
import org.xml.sax.XMLReader;
import org.apache.xerces.parsers.SAXParser;

public class SaxParser extends DefaultHandler
    implements ContentHandler, DTDHandler, EntityResolver {

    public transient static final String STYLE_SHEET_TAG = "xml-stylesheet";
    public transient static final String EXTERNAL_ENTITY = "ExternalEntity";

    public static void main(String[] args) {
        new SaxParser().execute();
    }

    public void execute() {
        String pathFileXml = "test/XML.xml";

        final XMLReader parser = new SAXParser();
        parser.setContentHandler(this);
        parser.setDTDHandler(this);
        parser.setEntityResolver(this);

        try {
            parser.parse(pathFileXml);
        } catch (IOException e) {
            e.printStackTrace();
        } catch (SAXException e) {

            if (SaxParser.STYLE_SHEET_TAG.equals(e.getMessage())
                    || SaxParser.EXTERNAL_ENTITY.equals(e.getMessage())) {
                System.out.println("CATCH ERROR");
            }
            e.printStackTrace();
        }
        System.out.println("OK");
    }

    @Override
    public void processingInstruction(String target, String data)
            throws SAXException {
        System.out.println("Processing Instruction");
        System.out.println("PI=> target: " + target + ", data: " + data);

        if (STYLE_SHEET_TAG.equalsIgnoreCase(target.trim())) {
            throw new SAXException(STYLE_SHEET_TAG);
        }
    }

    @Override
    public InputSource resolveEntity(String publicId, String systemId)
            throws IOException, SAXException {
        System.out.println("publicId: " + publicId + ", systemId: " + systemId);
        throw new SAXException(SaxParser.EXTERNAL_ENTITY);
    }
}