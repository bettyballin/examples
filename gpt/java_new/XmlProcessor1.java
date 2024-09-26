import javax.xml.stream.XMLInputFactory;
import javax.xml.stream.XMLResolver;
import javax.xml.stream.XMLStreamException;

public class XmlProcessor1 {
    public void configureXMLInputFactory() {
        XMLInputFactory xif = XMLInputFactory.newInstance();
        xif.setProperty(XMLInputFactory.IS_REPLACING_ENTITY_REFERENCES, false);
        xif.setXMLResolver(new XMLResolver() {
            @Override
            public Object resolveEntity(String publicID, String systemID, String baseURI, String namespace) throws XMLStreamException {
                throw new XMLStreamException("External entity resolution is disabled");
            }
        });
    }
    
    public static void main(String[] args) {
        XmlProcessor1 processor = new XmlProcessor1();
        processor.configureXMLInputFactory();
    }
}