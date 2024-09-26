import java.math.BigInteger;
import java.security.KeyFactory;
import java.security.PrivateKey;
import java.security.spec.RSAPrivateCrtKeySpec;

public class Temp1109 {
    public static void main(String[] args) throws Exception {
        // Example values for the RSA key components
        BigInteger modulus = new BigInteger("1234567890");
        BigInteger publicExponent = new BigInteger("65537");
        BigInteger privateExponent = new BigInteger("1234567890");
        BigInteger primeP = new BigInteger("1234567890");
        BigInteger primeQ = new BigInteger("1234567890");
        BigInteger exponentP = new BigInteger("1234567890");
        BigInteger exponentQ = new BigInteger("1234567890");
        BigInteger coefficient = new BigInteger("1234567890");

        RSAPrivateCrtKeySpec spec = new RSAPrivateCrtKeySpec(modulus, publicExponent, privateExponent, primeP, primeQ, exponentP, exponentQ, coefficient);
        PrivateKey privKey = KeyFactory.getInstance("RSA").generatePrivate(spec);

        System.out.println("Private Key: " + privKey);
    }
}