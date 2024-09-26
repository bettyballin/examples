Here is the corrected code:


import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.math.BigInteger;
import java.security.GeneralSecurityException;
import java.security.KeyFactory;
import java.security.spec.InvalidKeySpecException;
import java.security.spec.PKCS8EncodedKeySpec;
import java.security.spec.X509EncodedKeySpec;
import java.security.interfaces.RSAPrivateCrtKey;
import java.security.interfaces.RSAPublicKey;

public class Temp793 {
    public static void main(String[] args) {
        try {
            loadkeys();
        } catch (IOException | GeneralSecurityException e) {
            e.printStackTrace();
        }
    }

    private static void loadkeys() throws IOException, GeneralSecurityException {
        byte[] publicKeyBytes = new byte[(int) publicKeyFile.length()];
        try (FileInputStream publicFis = new FileInputStream(publicKeyFile);
             BufferedInputStream bis = new BufferedInputStream(publicFis)) {
            int bytesRead = bis.read(publicKeyBytes);
            if (bytesRead > 0) {
                X509EncodedKeySpec publicKeySpec = new X509EncodedKeySpec(publicKeyBytes);
                KeyFactory factory = KeyFactory.getInstance("RSA");
                RSAPublicKey pubKey = (RSAPublicKey) factory.generatePublic(publicKeySpec);
                BigInteger pKeyModulus = pubKey.getModulus();
                BigInteger pKeyExponent = pubKey.getPublicExponent();
                System.out.println("PUBLIC KEY EXPO : " + pKeyExponent);
            } else {
                System.out.println("Error reading public key file");
            }
        }

        byte[] privateKeyBytes = new byte[(int) privateKeyFile.length()];
        try (FileInputStream privateFis = new FileInputStream(privateKeyFile);
             BufferedInputStream bis = new BufferedInputStream(privateFis)) {
            int bytesRead = bis.read(privateKeyBytes);
            if (bytesRead > 0) {
                PKCS8EncodedKeySpec spec = new PKCS8EncodedKeySpec(privateKeyBytes);
                KeyFactory keyFactory = KeyFactory.getInstance("RSA");
                RSAPrivateCrtKey privKey = (RSAPrivateCrtKey) keyFactory.generatePrivate(spec);
                BigInteger pKeyModulus = privKey.getModulus();
                BigInteger pKeyExponent = privKey.getPublicExponent();
                System.out.println("PRIVATE KEY : " + pKeyExponent);
            } else {
                System.out.println("Error reading private key file");
            }
        } catch (InvalidKeySpecException e) {
            System.out.println("Invalid key spec: " + e.getMessage());
        }
    }

    // Placeholder for publicKeyFile and privateKeyFile
    private static final File publicKeyFile = new File("path_to_public_key_file");
    private static final File privateKeyFile = new File("path_to_private_key_file");
}