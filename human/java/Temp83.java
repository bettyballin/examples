import java.security.AccessController;
import java.security.PrivilegedAction;

public class Temp83 {
    public static void main(String[] args) {
        new Temp83().init();
    }

    public void init() {
        AccessController.doPrivileged(new PrivilegedAction<Object>() {
            @Override
            public Object run() {
                // Put your original init() code here.
                System.out.println("Privileged Action Executed");
                return null;
            }
        });
    }
}