import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.io.xml.StaxDriver;
import com.ctc.wstx.api.WstxInputProperties;
import com.ctc.wstx.stax.WstxInputFactory;

import javax.xml.stream.XMLInputFactory;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.XMLStreamReader;

public class Temp812 {
    public static void main(String[] args) throws XMLStreamException {
        XStream xstream = new XStream(new StaxDriver() {
            @Override
            public XMLInputFactory createXMLInputFactory() {
                return new WstxInputFactory() {
                    @Override
                    protected void configure(XMLStreamReader sr, boolean forParsing) throws XMLStreamException {
                        super.configure(sr, forParsing);
                        sr.setProperty(WstxInputProperties.P_MAX_ENTITY_DEPTH, 1); // Limit entity expansion depth to prevent billion laughs attack
                        sr.setProperty(WstxInputProperties.P_MAX_ATTRIBUTE_SIZE, 1000000); // Set maximum attribute size to a reasonable value (e.g. 10 MB)
                    }
                };
            }
        });
    }
}