import java.security.AccessController;
import java.security.PrivilegedAction;

public class Temp302 {
    public static void main(String[] args) {
        Temp302 temp = new Temp302();
        temp.callFromJavaScript("example");
    }

    public void callFromJavaScript(final String param) {
        AccessController.doPrivileged(new PrivilegedAction<Void>() {
            public Void run() {
                // call code to make the connection..
                System.out.println("Parameter: " + param);
                return null;
            }
        });
    }
}