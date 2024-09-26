import java.applet.Applet;
import java.net.URL;
import java.net.MalformedURLException;

public class YourApplet extends Applet {

    public void init() {
        try {
            performPrivilegedAction();
        } catch (SecurityException se) {
            redirectToErrorPage("error.html");
        }
    }

    private void performPrivilegedAction() {
        // Perform privileged action or throw SecurityException
    }

    private void redirectToErrorPage(String errorPage) {
        try {
            getAppletContext().showDocument(new URL(getCodeBase(), errorPage));
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
    }
}