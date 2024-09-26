import java.util.Arrays;
import java.util.Base64;

public class Main54 {
    public static void main(String[] args) throws Exception {
        String ciphertext = "U2FsdGVkX1+abc123"; // Example ciphertext string
        byte[] ctBytes = Base64.getDecoder().decode(ciphertext.getBytes("UTF-8"));
        System.out.println("Is salted: " + new String(Arrays.copyOf(ctBytes, 8)).equals("Salted__"));
    }
}