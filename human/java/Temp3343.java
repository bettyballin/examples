import java.util.Base64;

public class Temp3343 {
    public static void main(String[] args) {
        String decodedPlaintext = "Hello, World!";
        String encodedPlaintext = Base64.getEncoder().encodeToString(decodedPlaintext.getBytes());
        
        System.out.println(encodedPlaintext);
    }
}