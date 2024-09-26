import java.math.BigInteger;
import java.util.Base64;

public class Temp2227 {
    public static void main(String[] args) {
        String n = "your_base64url_encoded_modulus";
        String e = "your_base64url_encoded_exponent";
        
        BigInteger modulus = new BigInteger(1, Base64.getUrlDecoder().decode(n));
        BigInteger exponent = new BigInteger(1, Base64.getUrlDecoder().decode(e));

        System.out.println("Modulus: " + modulus);
        System.out.println("Exponent: " + exponent);
    }
}