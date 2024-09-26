import java.math.BigInteger;
import java.security.KeyFactory;
import java.security.KeyPair;
import java.security.KeyPairGenerator;
import java.security.NoSuchAlgorithmException;
import java.security.spec.InvalidKeySpecException;
import java.security.spec.RSAPrivateCrtKeySpec;
import java.security.spec.RSAPublicKeySpec;

public class RSAKeyInfo {
    public static void main(String[] args) throws NoSuchAlgorithmException, InvalidKeySpecException {
        KeyPairGenerator keyGen = KeyPairGenerator.getInstance("RSA");
        keyGen.initialize(2048);
        KeyPair keyPair = keyGen.generateKeyPair();

        KeyFactory kf = KeyFactory.getInstance("RSA");
        RSAPublicKeySpec publicKeySpec = kf.getKeySpec(keyPair.getPublic(), RSAPublicKeySpec.class);
        BigInteger modulus = publicKeySpec.getModulus();
        BigInteger publicExponent = publicKeySpec.getPublicExponent();

        System.out.println("modulus: " + modulus.toString(16));
        System.out.println("public exponent: " + publicExponent.toString(16));

        RSAPrivateCrtKeySpec privateKeySpec = kf.getKeySpec(keyPair.getPrivate(), RSAPrivateCrtKeySpec.class);
        BigInteger privateModulus = privateKeySpec.getModulus();
        BigInteger privatePublicExponent = privateKeySpec.getPublicExponent();
        BigInteger privatePrimeP = privateKeySpec.getPrimeP();
        BigInteger privatePrimeQ = privateKeySpec.getPrimeQ();
        BigInteger privatePrimeExponentP = privateKeySpec.getPrimeExponentP();
        BigInteger privatePrimeExponentQ = privateKeySpec.getPrimeExponentQ();
        BigInteger privateCrtCoefficient = privateKeySpec.getCrtCoefficient();

        System.out.println("private modulus: " + privateModulus.toString(16));
        System.out.println("private public exponent: " + privatePublicExponent.toString(16));
        System.out.println("prime p: " + privatePrimeP.toString(16));
        System.out.println("prime q: " + privatePrimeQ.toString(16));
        System.out.println("prime exponent p: " + privatePrimeExponentP.toString(16));
        System.out.println("prime exponent q: " + privatePrimeExponentQ.toString(16));
        System.out.println("crt coefficient: " + privateCrtCoefficient.toString(16));
    }
}