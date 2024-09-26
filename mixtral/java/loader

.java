import java.security.AccessController;
import java.security.PrivilegedAction;

public class Main {
    public static void main(String[] args) {
        AccessController.doPrivileged(new PrivilegedAction<Void>() {
            @Override
            public Void run() {
                ClassLoader systemClassLoader = ClassLoader.getSystemClassLoader();
                
                // Perform operations with the System class loader
                System.out.println("System ClassLoader: " + systemClassLoader);

                return null;
            }
        });
    }
}