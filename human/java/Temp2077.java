import javax.xml.ws.BindingProvider;
import java.util.Map;
import java.util.Properties;

public class Temp2077 {
    public static void main(String[] args) {
        XxxService service = new XxxService();
        BindingProvider bp = (BindingProvider) service.getXxxPort();
        final Map<String, Object> rqc = bp.getRequestContext();

        Properties p = new Properties();
        p.setProperty("org.apache.ws.security.crypto.merlin.keystore.file", "path/to/keystore/file");
        p.setProperty("org.apache.ws.security.crypto.merlin.keystore.password", "yourKeystorePassword");
        p.setProperty("org.apache.ws.security.crypto.merlin.keystore.type", "yourKeystoreType");
        p.setProperty("org.apache.ws.security.crypto.merlin.keystore.alias", "yourKeystoreAlias");

        rqc.put("security.signature.properties", p);
        rqc.put("security.encryption.properties", p);
    }
}

// Dummy classes to make the code compile
class XxxService {
    public XxxPort getXxxPort() {
        return new XxxPort();
    }
}

class XxxPort {
}