import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.XStreamException;

public class Temp1137 {
    public static void main(String[] args) {
        // example usage
        try {
            Object result = parseStr("<xml></xml>");
            System.out.println(result);
        } catch (XStreamException e) {
            e.printStackTrace();
        }
    }

    public static Object parseStr(String str) throws XStreamException {
        XStream xstream = new XStream();

        // Disable XXE attacks
        xstream.setupDefaultSecurity();

        // Assuming myAnnotaedClasses is defined somewhere
        Class<?>[] myAnnotaedClasses = {}; // Add your annotated classes here
        xstream.processAnnotations(myAnnotaedClasses);

        return xstream.fromXML(str);
    }
}