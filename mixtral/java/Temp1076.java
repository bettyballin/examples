import org.w3c.dom.ls.LSResourceResolver;
import org.w3c.dom.ls.LSInput;

import javax.xml.transform.stream.StreamSource;
import javax.xml.validation.Schema;
import javax.xml.validation.SchemaFactory;
import javax.xml.validation.Validator;
import java.io.StringReader;

public class Temp1076 {
    public static void main(String[] args) throws Exception {

        SchemaFactory schemaFactory = SchemaFactory
                .newInstance("http://www.w3.org/2001/XMLSchema");

        schemaFactory.setFeature("http://apache.org/xml/features/disallow-doctype-decl", true);

        // Create a custom LSResourceResolver that does nothing
        LSResourceResolver resolver = new LSResourceResolver() {
            @Override
            public LSInput resolveResource(String type, String namespaceURI,
                                           String publicId, String systemId,
                                           String baseURI) {
                return null;
            }
        };

        // Set the custom resolver to prevent external entity resolution
        schemaFactory.setResourceResolver(resolver);

        Schema schema = schemaFactory
                .newSchema(new StreamSource("path/to/your-xml-schema"));
        Validator validator = schema
                .newValidator();

        validator.validate(
                new StreamSource(
                        new StringReader("<root>Your XML content</root>")
                ));
    }
}