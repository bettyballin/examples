import java.security.Provider;
import java.security.Security;

public class MyProvider extends Provider {
    public MyProvider() {
        super("MyProvider", 1.0, "My Custom Provider");
        put("MessageDigest.MyAlgorithm", "com.example.MyAlgorithm");
    }

    public static void main(String[] args) {
        // Register the provider
        Security.addProvider(new MyProvider());
        System.out.println("Provider registered successfully.");
    }
}