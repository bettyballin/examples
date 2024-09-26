import java.math.*;
import java.security.*;
import java.security.spec.*;
import javax.crypto.*;

public class RSA {
    public static void main(String[] args) throws Exception {
        SecureRandom random = new SecureRandom();

        BigInteger p = BigInteger.probablePrime(1024, random);
        BigInteger q = BigInteger.probablePrime(1024, random);

        // Calculate n
        BigInteger n = p.multiply(q);

        // Calculate phi
        BigInteger phi = (p.subtract(BigInteger.ONE)).multiply((q.subtract(BigInteger.ONE)));

        // Generate public and private exponents
        BigInteger e = new BigInteger("65537");

        if (!e.gcd(phi).equals(BigInteger.valueOf(1))) {
            throw new IllegalArgumentException("Invalid RSA parameters.");
        }

        BigInteger d = e.modInverse(phi);

        // Create public and private keys
        KeyFactory keyFac = KeyFactory.getInstance("RSA");

        Cipher cipher = Cipher.getInstance("RSA/ECB/OAEPWithSHA-256AndMGF1Padding");

        RSAPublicKeySpec pubKeySpec = new RSAPublicKeySpec(n, e);

        PublicKey publicKey = keyFac.generatePublic(pubKeySpec);

        cipher.init(Cipher.ENCRYPT_MODE, publicKey);

        String string = "this is a test";

        byte[] bytes = string.getBytes();

        // Encrypt
        byte[] encryptedData = cipher.doFinal(bytes);

        RSAPrivateKeySpec privKeySpec = new RSAPrivateKeySpec(n, d);

        PrivateKey privateKey = keyFac.generatePrivate(privKeySpec);

        // Decrypt
        cipher.init(Cipher.DECRYPT_MODE, privateKey);
        byte[] decryptedData = cipher.doFinal(encryptedData);

        String decryptedString = new String(decryptedData);

        System.out.println("Original: " + string);
        System.out.println("Encrypted: " + new BigInteger(1, encryptedData).toString(16));
        System.out.println("Decrypted: " + decryptedString);
    }
}