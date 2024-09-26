import java.util.Base64;
import java.util.Arrays;

public class Temp1296 {
    public static void main(String[] args) {
        String ciphertext = "U2FsdGVkX1+Y2v3mJ1Gm7W2E7R+P5eF5"; // Example Base64 encoded ciphertext
        try {
            byte[] ctBytes = Base64.getDecoder().decode(ciphertext.getBytes("UTF-8"));
            System.out.println("Is salted: " + new String(Arrays.copyOf(ctBytes, 8)).equals("Salted__"));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}