import java.io.File;
import java.io.StringReader;
import javax.xml.XMLConstants;
import javax.xml.transform.stream.StreamSource;
import javax.xml.validation.Schema;
import javax.xml.validation.SchemaFactory;
import javax.xml.validation.Validator;

public class Temp779 {
    public static void main(String[] args) {
        try {
            SchemaFactory schemaFactory = SchemaFactory.newInstance(XMLConstants.W3C_XML_SCHEMA_NS_URI);
            schemaFactory.setProperty(XMLConstants.ACCESS_EXTERNAL_DTD, "");
            schemaFactory.setProperty(XMLConstants.ACCESS_EXTERNAL_SCHEMA, "");

            Schema myschema = schemaFactory.newSchema(new File("path/to/your/schema.xsd"));

            Validator validator = myschema.newValidator();
            validator.setProperty(XMLConstants.ACCESS_EXTERNAL_DTD, "");
            validator.setProperty(XMLConstants.ACCESS_EXTERNAL_SCHEMA, ""); // Added this line

            String xmlString = "<your_xml_string_here>"; // Replace with actual XML string
            validator.validate(new StreamSource(new StringReader(xmlString)));
            
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}