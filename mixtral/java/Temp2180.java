import com.ctc.wstx.stax.WstxInputFactory;
import com.ctc.wstx.api.WstxInputProperties;
import javax.xml.stream.XMLInputFactory;
import javax.xml.transform.stream.StreamResult;
import javax.xml.validation.Schema;
import javax.xml.validation.SchemaFactory;
import javax.xml.validation.Validator;
import javax.xml.stream.XMLStreamReader;
import javax.xml.transform.stax.StAXSource;
import java.io.StringWriter;
import java.io.InputStream;

public class Temp2180 {
    public static void main(String[] args) {
        try {
            XMLInputFactory inputFactory = new WstxInputFactory();
            inputFactory.setProperty(WstxInputProperties.P_MAX_ENTITY_COUNT, 0);

            SchemaFactory factory = SchemaFactory.newInstance("http://www.w3.org/2001/XMLSchema");
            InputStream xsdsStreamSource = Temp2180.class.getResourceAsStream("/path/to/your/schema.xsd");
            Schema schema = factory.newSchema(new StreamSource(xsdsStreamSource));
            Validator validator = schema.newValidator();

            InputStream xmlInputStream = Temp2180.class.getResourceAsStream("/path/to/your/input.xml");
            XMLStreamReader reader = inputFactory.createXMLStreamReader(xmlInputStream);
            StAXSource xmlSource = new StAXSource(reader);

            StringWriter writer = new StringWriter();
            validator.validate(xmlSource, new StreamResult(writer));

            System.out.println(writer.toString());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}


Please ensure to replace `/path/to/your/schema.xsd` and `/path/to/your/input.xml` with the actual paths to your XSD schema and XML input files respectively. Additionally, make sure you have the necessary dependencies for the Woodstox library and other required libraries in your project's classpath.