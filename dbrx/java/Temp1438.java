import javax.xml.XMLConstants;
import javax.xml.transform.stream.StreamSource;
import javax.xml.validation.Schema;
import javax.xml.validation.SchemaFactory;
import javax.xml.validation.Validator;
import java.io.File;

public class Temp1438 {
    public static void main(String[] args) {
        try {
            SchemaFactory schemaFactory = SchemaFactory.newInstance(XMLConstants.W3C_XML_SCHEMA_NS_URI);
            schemaFactory.setProperty(XMLConstants.ACCESS_EXTERNAL_DTD, ""); 
            schemaFactory.setProperty(XMLConstants.ACCESS_EXTERNAL_SCHEMA, ""); 

            Schema schema = schemaFactory.newSchema(new File("schema.xsd"));
            Validator validator = schema.newValidator();
            validator.setFeature(XMLConstants.FEATURE_SECURE_PROCESSING, true); 

            File xmlFile = new File("example.xml");
            validator.validate(new StreamSource(xmlFile));

            System.out.println("XML is valid.");

        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("XML is not valid.");
        }
    }
}