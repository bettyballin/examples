import org.eclipse.jetty.util.ssl.SslContextFactory;

public class Temp465 {
    public static void main(String[] args) {
        SslContextFactory sslContextFactory = new SslContextFactory.Server();
        sslContextFactory.setKeyStorePath("path/to/keystore");
        sslContextFactory.setTrustStorePath("path/to/truststore");

        // Assuming CustomKeyStoreFactory is defined elsewhere in your project
        // Replace ... with appropriate arguments for the constructor
        CustomKeyStoreFactory keyStoreFactory = new CustomKeyStoreFactory(...);
        sslContextFactory.setKeyStoreFactory(keyStoreFactory);

        // Enable reloading
        sslContextFactory.setReloadingEnabled(true);
    }
}

// Dummy CustomKeyStoreFactory class; replace with actual implementation
class CustomKeyStoreFactory {
    public CustomKeyStoreFactory(Object... args) {
        // Constructor logic
    }
}


Ensure you have the necessary imports and dependencies in your project for this code to compile and run successfully.