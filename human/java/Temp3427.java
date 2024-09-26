import java.security.*;
import java.security.spec.*;
import javax.crypto.*;
import javax.crypto.spec.*;
import java.security.AlgorithmParameters;
import org.bouncycastle.jce.provider.BouncyCastleProvider;

public class Temp3427 {
    public static void main(String[] args) {
        try {
            String plainText = "Hello, World!";
            String publicKey = "YourPublicKeyHere"; // Replace with an actual public key
            byte[] encrypted = encrypt(plainText, publicKey);
            System.out.println("Encrypted Text: " + new String(encrypted));
        } catch (GeneralSecurityException e) {
            e.printStackTrace();
        }
    }

    public static byte[] encrypt(String plainText, String publicKey) throws GeneralSecurityException {
        AlgorithmParameters parameters = AlgorithmParameters.getInstance("OAEP", new BouncyCastleProvider());
        AlgorithmParameterSpec specification = new OAEPParameterSpec("SHA-256", "MGF1", MGF1ParameterSpec.SHA256, PSource.PSpecified.DEFAULT);
        parameters.init(specification);
        Cipher cipher = Cipher.getInstance("RSA/ECB/OAEPWithSHA-256AndMGF1Padding", new BouncyCastleProvider());
        cipher.init(Cipher.ENCRYPT_MODE, getPublicKey(publicKey), parameters);
        return cipher.doFinal(plainText.getBytes());
    }

    private static PublicKey getPublicKey(String base64PublicKey) throws GeneralSecurityException {
        byte[] decodedKey = java.util.Base64.getDecoder().decode(base64PublicKey);
        X509EncodedKeySpec keySpec = new X509EncodedKeySpec(decodedKey);
        KeyFactory keyFactory = KeyFactory.getInstance("RSA", new BouncyCastleProvider());
        return keyFactory.generatePublic(keySpec);
    }
}