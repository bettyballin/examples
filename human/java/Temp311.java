import javax.crypto.spec.SecretKeySpec;

public class Temp311 {
    public static void main(String[] args) {
        // Example usage of SecretKeySpec
        byte[] key = new byte[16]; // 128 bit key
        SecretKeySpec secretKey = new SecretKeySpec(key, "AES");
        System.out.println("SecretKeySpec created successfully: " + secretKey);
    }
}