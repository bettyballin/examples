import org.xml.sax.*;
import org.xml.sax.helpers.DefaultHandler;

import java.io.IOException;

public class SaxParser extends DefaultHandler {

    public static final String STYLE_SHEET_TAG = "xml-stylesheet";
    public static final String EXTERNAL_ENTITY = "ExternalEntity";

    public static void main(String[] args) {
        new SaxParser().execute();
    }

    public void execute() {
        String pathFileXml = "test/XML.xml";

        try {
            XMLReader parser = XMLReaderFactory.createXMLReader();
            parser.setContentHandler(this);
            parser.setDTDHandler(this);
            parser.setEntityResolver(this);
            parser.parse(pathFileXml);
        } catch (IOException | SAXException e) {
            if (STYLE_SHEET_TAG.equals(e.getMessage())
                || EXTERNAL_ENTITY.equals(e.getMessage())) {
                System.out.println("CATCH ERRORE");
            } else {
                e.printStackTrace();
            }
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
            throws SAXException {
        System.out.println("publicId: " + publicId + ", systemId: " + systemId);
        throw new SAXException(EXTERNAL_ENTITY);
    }
}