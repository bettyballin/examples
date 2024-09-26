import java.math.BigInteger;
import java.util.Base64;

public class Temp2226 {
    public static void main(String[] args) {
        // Example Base64 encoded modulus and exponent strings
        String modulusBase64 = "AKOw5...";  // Replace with actual Base64 encoded modulus
        String exponentBase64 = "AQAB";     // Replace with actual Base64 encoded exponent
        
        // Decode Base64 strings to byte arrays
        byte[] modulusBytes = Base64.getDecoder().decode(modulusBase64);
        byte[] exponentBytes = Base64.getDecoder().decode(exponentBase64);
        
        // Create BigInteger instances from byte arrays
        BigInteger modulus = new BigInteger(1, modulusBytes);
        BigInteger exponent = new BigInteger(1, exponentBytes);
        
        // Print the BigInteger values
        System.out.println("Modulus: " + modulus);
        System.out.println("Exponent: " + exponent);
    }
}