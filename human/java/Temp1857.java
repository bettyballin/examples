import javax.xml.transform.OutputKeys;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.TransformerFactoryConfigurationError;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import org.w3c.dom.Node;
import java.io.StringWriter;

public class Temp1857 {
    public static void main(String[] args) {
        // Example usage
        // Assuming you have a Node instance to test the method
        // Node node = ...; 
        // Uncomment the above line and provide a valid Node instance to test
        // Temp1857 temp = new Temp1857();
        // try {
        //     String result = temp.nodeToString(node);
        //     System.out.println(result);
        // } catch (TransformerException e) {
        //     e.printStackTrace();
        // }
    }

    public String nodeToString(Node node) throws TransformerFactoryConfigurationError, TransformerException {
        StringWriter sw = new StringWriter();
        Transformer t = TransformerFactory.newInstance().newTransformer();
        t.setOutputProperty(OutputKeys.OMIT_XML_DECLARATION, "yes");
        t.setOutputProperty(OutputKeys.INDENT, "yes");
        t.transform(new DOMSource(node), new StreamResult(sw));
        return sw.toString();
    }
}