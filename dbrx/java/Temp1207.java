import java.math.BigInteger;

public class Temp1207 {
    public static void main(String[] args) {
        BigInteger messageInt = new BigInteger("123456789"); // example message
        BigInteger e = BigInteger.valueOf(65537); // example public exponent
        BigInteger d = BigInteger.valueOf(1234567); // example private exponent
        BigInteger N = new BigInteger("987654321"); // example modulus

        BigInteger c = messageInt.modPow(e, N); // Encryption
        System.out.println("Encrypted message: " + c);

        BigInteger msgback = c.modPow(d, N);   // Decryption
        System.out.println("Decrypted message: " + msgback);
    }
}