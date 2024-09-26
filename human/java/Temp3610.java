import java.util.Base64;

public class Temp3610 {
    public static void main(String[] args) {
        byte[] finalCiphertext = "example".getBytes(); // Example byte array, replace with your actual data
        String encodedString = Base64.getEncoder().encodeToString(finalCiphertext);
        System.out.println(encodedString);
    }
}