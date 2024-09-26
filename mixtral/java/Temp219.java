import java.math.BigInteger;

public class Temp219 {
    public static void main(String[] args) {
        // Example values for modulus and exponent
        BigInteger modulus = new BigInteger("12345678901234567890");
        BigInteger exponent = new BigInteger("65537");

        String modulusHex = modulus.toString(16);
        String exponentHex = exponent.toString(16);

        // Now 'modulusHex' and 'exponentHex' will be in the same format as openssl output
        System.out.println("Modulus (hex): " + modulusHex);
        System.out.println("Exponent (hex): " + exponentHex);
    }
}