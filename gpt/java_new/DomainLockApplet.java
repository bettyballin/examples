import java.applet.Applet;
import java.net.URL;

public class DomainLockApplet extends Applet {

    private static final String[] ALLOWED_DOMAINS = {
        "www.example.com",
        "example.com"
    };

    public void init() {
        try {
            URL documentBase = getDocumentBase();
            String host = documentBase.getHost();
            boolean allowed = false;
            for (String domain : ALLOWED_DOMAINS) {
                if (host.equals(domain)) {
                    allowed = true;
                    break;
                }
            }
            if (!allowed) {
                throw new Exception("Access denied");
            }
        } catch (Exception e) {
            e.printStackTrace();
            // Handle exception as necessary
        }
    }
}