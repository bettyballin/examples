import java.security.PrivateKey;

public class Main49 {
    public static void main(String[] args) {
        PrivateKey key = // ...assuming key is initialized properly

        byte[] enc_key = key.getEncoded();

        // Byte array to string
        StringBuilder key_builder = new StringBuilder();
        for (byte b : enc_key) {
            key_builder.append(String.format("%02x", b));
        }

        String serialized_key = key_builder.toString();
        // ...use serialized_key as needed
    }
}