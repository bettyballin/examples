import java.math.BigInteger;
import java.security.spec.RSAPrivateCrtKeySpec;

public class Temp2039 {
    public static void main(String[] args) {
        // Example values for the RSA components
        BigInteger modulus = new BigInteger("1234567890123456789012345678901234567890");
        BigInteger publicExponent = new BigInteger("65537");
        BigInteger privateExponent = new BigInteger("1234567890123456789012345678901234567890123456789012345678901234567890");
        BigInteger primeP = new BigInteger("1234567890123456789012345678901234567890");
        BigInteger primeQ = new BigInteger("1234567890123456789012345678901234567890");
        BigInteger primeExpP = new BigInteger("1234567890123456789012345678901234567890");
        BigInteger primeExpQ = new BigInteger("1234567890123456789012345678901234567890");
        BigInteger crtCoefficient = new BigInteger("1234567890123456789012345678901234567890");

        RSAPrivateCrtKeySpec privateKeySpec = 
            new RSAPrivateCrtKeySpec(modulus, publicExponent, privateExponent, primeP, primeQ, primeExpP, primeExpQ, crtCoefficient);

        System.out.println("RSAPrivateCrtKeySpec created successfully.");
    }
}