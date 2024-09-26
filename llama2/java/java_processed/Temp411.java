import org.bouncycastle.crypto.engines.RSAEngine;
import org.bouncycastle.crypto.params.RSAKeyGenerationParameters;
import org.bouncycastle.crypto.params.RSAPrivateCrtKeyParameters;
import org.bouncycastle.jce.provider.BouncyCastleProvider;

import java.math.BigInteger;
import java.security.KeyPair;
import java.security.KeyPairGenerator;
import java.security.Security;
import java.security.SecureRandom;
import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;
import javax.crypto.SecretKey;
import javax.crypto.BadPaddingException;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;

public class Temp411 {
    public static void main(String[] args) {
        Security.addProvider(new BouncyCastleProvider());
        try {
            // Generate a new RSA key pair
            KeyPairGenerator keyGen = KeyPairGenerator.getInstance("RSA", "BC");
            keyGen.initialize(2048, new SecureRandom());
            KeyPair keyPair = keyGen.generateKeyPair();

            // Get the private key
            RSAPrivateCrtKeyParameters privateKeyParams = new RSAPrivateCrtKeyParameters(
                keyPair.getPrivate().getModulus(),
                keyPair.getPublic().getPublicExponent(),
                keyPair.getPrivate().getPrivateExponent(),
                null, null, null, null, null
            );

            // Initialize RSA engine
            RSAEngine rsa = new RSAEngine();
            rsa.init(true, privateKeyParams);

            // Encrypt the private key using AES
            String myPassphrase = "my_passphrase";
            byte[] encryptedPrivateKey = encryptPrivateKey(keyPair.getPrivate().getEncoded(), myPassphrase);

            // Print encrypted private key
            System.out.println("Encrypted Private Key: " + bytesToHex(encryptedPrivateKey));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static byte[] encryptPrivateKey(byte[] privateKeyBytes, String passphrase) throws NoSuchPaddingException, NoSuchAlgorithmException, InvalidKeyException, BadPaddingException, IllegalBlockSizeException {
        SecretKeySpec secretKey = new SecretKeySpec(passphrase.getBytes(), "AES");
        Cipher cipher = Cipher.getInstance("AES");
        cipher.init(Cipher.ENCRYPT_MODE, secretKey);
        return cipher.doFinal(privateKeyBytes);
    }

    public static String bytesToHex(byte[] bytes) {
        StringBuilder sb = new StringBuilder();
        for (byte b : bytes) {
            sb.append(String.format("%02x", b));
        }
        return sb.toString();
    }
}