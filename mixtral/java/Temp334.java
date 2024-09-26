import java.security.KeyPair;
import java.security.KeyPairGenerator;
import java.security.SecureRandom;
import java.security.interfaces.RSAPrivateCrtKey;
import java.math.BigInteger;

public class Temp334 {
    public static void main(String[] args) throws Exception {
        SecureRandom random = new SecureRandom();
        KeyPairGenerator kpg = KeyPairGenerator.getInstance("RSA");
        kpg.initialize(2048, random);
        KeyPair keyPair = kpg.generateKeyPair();
        RSAPrivateCrtKey privateKey = (RSAPrivateCrtKey) keyPair.getPrivate();
        BigInteger modulus = privateKey.getModulus();
        BigInteger sk = privateKey.getPrivateExponent();

        System.out.println("Modulus: " + modulus);
        System.out.println("Private Exponent: " + sk);
    }
}