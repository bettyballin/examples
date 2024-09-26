import javax.xml.XMLConstants;
import javax.xml.transform.stream.StreamSource;
import javax.xml.validation.Schema;
import javax.xml.validation.SchemaFactory;
import javax.xml.validation.Validator;
import java.io.StringReader;

public class Temp1897 {
    public static void main(String[] args) {
        String xmlString = "<root></root>"; // Replace with your actual XML string

        SchemaFactory factory = SchemaFactory.newInstance("http://www.w3.org/2001/XMLSchema");
        try {
            Schema myschema = factory.newSchema();
            Validator validator = myschema.newValidator();
            validator.setProperty(XMLConstants.ACCESS_EXTERNAL_DTD, "");
            validator.setProperty(XMLConstants.ACCESS_EXTERNAL_SCHEMA, "");
            validator.validate(new StreamSource(new StringReader(xmlString)));
            System.out.println("XML is valid.");
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("XML is not valid.");
        }
    }
}