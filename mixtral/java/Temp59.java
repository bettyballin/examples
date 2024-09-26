import java.nio.charset.StandardCharsets;
import java.io.PrintStream;

public class Temp59 {
    public static void main(String[] args) {
        byte[] bytes = {72, 101, 108, 108, 111}; // Example byte array, replace with your actual data
        String decryptedText = new String(bytes, StandardCharsets.UTF_8);
        PrintStream file = System.out; // Replace with actual PrintStream if needed
        file.println(decryptedText);
    }
}