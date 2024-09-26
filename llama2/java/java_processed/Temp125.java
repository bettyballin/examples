import java.math.BigInteger;

public class Temp125 {
    public static void main(String[] args) {
        // Example fileBytes in hexadecimal string format
        String fileBytes = "4d2"; // This is just an example, replace it with actual file bytes in hex
        
        // Converting hexadecimal string to BigInteger
        BigInteger fileData = new BigInteger(fileBytes, 16);
        
        // Print the BigInteger value
        System.out.println("BigInteger value: " + fileData);
    }
}