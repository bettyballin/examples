import java.security.Provider;

public class CustomProvider extends Provider {
    public CustomProvider() {
        super("Custom", 1.0, "A custom provider");

        // Remove MD5
        put("MessageDigest.MD5", null);

        // Add other algorithms if needed

        // Call this to ensure the algorithm is removed
        remove("MessageDigest.MD5");
    }

    public static void main(String[] args) {
        CustomProvider customProvider = new CustomProvider();
        System.out.println("Custom provider created: " + customProvider.getInfo());
    }
}