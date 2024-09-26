import java.util.Base64;

public class Temp2067 {
    public static void main(String[] args) {
        byte[] decrypted = {104, 101, 108, 108, 111}; // Example byte array
        String decryptedMessage = new String(Base64.getEncoder().encode(decrypted));
        System.out.println(decryptedMessage);
    }
}