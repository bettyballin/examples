import java.security.spec.KeySpec;
import java.security.spec.PKCS8EncodedKeySpec;
import java.util.Base64;

public class Temp967 {
    public static void main(String[] args) {
        // Example key for demonstration purposes
        String newKey = "MIIEvQIBADANBgkqhkiG9w0BAQEFAASCAmMwggJfAgEAAoGBAL5ZLkJ0+3Z2mLbq4/w7T7kXy/MX4zOQn5zF5CwP6nDq7T6Y9oD1a+8wV4hslZ/Jh6+4m8m9u5YfK+1HoZjZ1vU5GvCi4H3b2YgHkqIuCht3W9kMZGe7yqU+N5m9E8s7f5jovb5GybR2rJY8w2+4A==";
        KeySpec ks = new PKCS8EncodedKeySpec(Base64.getDecoder().decode(newKey));
        System.out.println("KeySpec generated successfully.");
    }
}