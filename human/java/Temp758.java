import java.security.KeyFactory;
import java.security.PublicKey;
import java.security.spec.X509EncodedKeySpec;
import javax.crypto.Cipher;

public class Temp758 {
    public static void main(String[] args) throws Exception {
        // Sample public key in Base64 (replace with actual key)
        String publicKeyStr = "MIIBIjANBgkqhkiG9w0BAQEFAAOCAQ8AMIIBCgKCAQEAqX3r5Emt7S5Y9bLkV6N5" + 
                              "c9YVJoX5uV8UH5/1cAnYz5U6xJt6XJ1uYQk4t4g5N1vLr6m1QZp1n2LZ5j4Rzj9f" + 
                              "8V4+3vqLSQ4yVh7NkB0N5P0A8U5uKfF8G1GHcP3sUoBsH5I1l8g9T4A2J8Z8j3Sz" + 
                              "4y2o3J8M7v7MK9tXs1i9t1uP9p6m3AlJ9VZ5XIoQ3T1fM5j3gQ8xTAN9DIu7dWzF" + 
                              "tA7V5Xq+U8c5T7G1Z3Zg5Z7FJm0u4J1YtqK6h3Q2F9WvO8G6Zk5yT5vQ5j4u4F3K" + 
                              "8s4f3y1b3Q1j3g9R2o6j3o9K3L5u7K5m9I8J3T1r3J5u7K3n9U8J6T5o7P8u7K3" + 
                              "N9I8J3T4o5u7K3n9Q6J4T5o7P8u7M5n9I8L3T1r3J5u7M3n9U8J6T5o7P8u7M4n" + 
                              "Q8J4T5o7P8u7K3m9I8L3T1r3J5u7K3n9U8J6T5o7P8u7K3n9I8J3T1r3J5u7P8M" + 
                              "5n9I8L3T1r3J5u7M3n9U8J6T5o7P8u7M4nQ8J4T5o7P8u7K3m9I8L3T1r3J5u7M" + 
                              "3n9U8J6T5o7P8u7K3n9I8J3T1r3J5u7M5n9I8L3T1r3J5u7M3n9U8J6T5o7P8u7" + 
                              "M4nQ8J4T5o7P8u7K3m9I8L3T1r3J5u7M3n9U8J6T5o7P8u7K3n9I8J3T1r3J5u7" + 
                              "P8M5n9I8L3T1r3J5u7M3n9U8J6T5o7P8u7M4nQ8J4T5o7P8u7K3m9I8L3T1r3J5u7M" + 
                              "3n9U8J6T5o7P8u7K3n9I8J3T1r3J5u7P8M5n9I8L3T1r3J5u7M3n9U8J6T5o7P8u7";

        byte[] publicKeyBytes = java.util.Base64.getDecoder().decode(publicKeyStr);
        X509EncodedKeySpec publicKeySpec1 = new X509EncodedKeySpec(publicKeyBytes);

        KeyFactory kf1 = KeyFactory.getInstance("RSA");
        PublicKey pkPublic1 = kf1.generatePublic(publicKeySpec1);

        Cipher pkCipher