import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;
import javax.crypto.spec.IvParameterSpec;
import java.nio.charset.StandardCharsets;
import java.security.NoSuchAlgorithmException;
import java.security.NoSuchProviderException;
import java.util.Arrays;

public class AESCBC {
    public static void main(String[] args) throws Exception {
        // Key and initialization vector (IV)
        String key = "0123456789abcdef";
        byte[] iv = new byte[16];

        // Message to encrypt
        String message = "Hello, World!";
        
        // Pad the message to be a multiple of 16 bytes
        byte[] messageBytes = message.getBytes(StandardCharsets.UTF_8);
        int paddingLength = 16 - (messageBytes.length % 16);
        byte[] paddedMessage = Arrays.copyOf(messageBytes, messageBytes.length + paddingLength);

        // Encryption
        Cipher cipher = Cipher.getInstance("AES/CBC/NoPadding");
        SecretKeySpec keySpec = new SecretKeySpec(key.getBytes(StandardCharsets.UTF_8), "AES");
        IvParameterSpec ivSpec = new IvParameterSpec(iv);
        cipher.init(Cipher.ENCRYPT_MODE, keySpec, ivSpec);
        byte[] encrypted = cipher.doFinal(paddedMessage);
        
        // Print the encrypted message
        System.out.println("Encrypted message (hex): " + bytesToHex(encrypted));
    }

    private static String bytesToHex(byte[] bytes) {
        StringBuilder sb = new StringBuilder();
        for (byte b : bytes) {
            sb.append(String.format("%02x", b));
        }
        return sb.toString();
    }
}