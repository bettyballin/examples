import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.io.HierarchicalStreamReader;
import com.thoughtworks.xstream.io.xml.StaxDriver;
import com.thoughtworks.xstream.io.xml.StaxReader;
import com.thoughtworks.xstream.io.xml.XmlFriendlyNameCoder;
import com.thoughtworks.xstream.security.NoTypePermission;
import com.thoughtworks.xstream.security.WildcardTypePermission;

import javax.xml.stream.XMLInputFactory;
import javax.xml.stream.XMLStreamReader;

public class SecureXStreamParser {

    public static Object parseStr(String str) throws Exception {
        // Create a secure StAX driver with a custom name coder
        StaxDriver staxDriver = new StaxDriver(new XmlFriendlyNameCoder()) {
            @Override
            public StaxReader createStaxReader(XMLStreamReader in) {
                in.setProperty(XMLInputFactory.IS_SUPPORTING_EXTERNAL_ENTITIES, Boolean.FALSE);
                in.setProperty(XMLInputFactory.SUPPORT_DTD, Boolean.FALSE);
                return super.createStaxReader(in);
            }
        };

        XStream xstream = new XStream(staxDriver);
        // Clear out existing permissions and set own ones
        xstream.addPermission(NoTypePermission.NONE);
        // Add permissions for types you need to allow
        xstream.addPermission(new WildcardTypePermission(new String[] {"your.package.**"}));
        
        return xstream.fromXML(str);
    }
}