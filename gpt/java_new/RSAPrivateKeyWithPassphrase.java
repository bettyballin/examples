import javax.crypto.Cipher;
import javax.crypto.EncryptedPrivateKeyInfo;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.PBEKeySpec;
import java.security.KeyFactory;
import java.security.PrivateKey;
import java.security.spec.PKCS8EncodedKeySpec;

public class RSAPrivateKeyWithPassphrase {

    public static PrivateKey loadPrivateKey(File encryptedPrivateKeyFile, String passphrase) throws Exception {
        // Read the encrypted private key bytes
        byte[] encryptedPrivateKeyBytes = Files.readAllBytes(encryptedPrivateKeyFile.toPath());

        // Extract the encrypted key information
        EncryptedPrivateKeyInfo encryptPKInfo = new EncryptedPrivateKeyInfo(encryptedPrivateKeyBytes);

        // Create PBE secret key
        PBEKeySpec pbeKeySpec = new PBEKeySpec(passphrase.toCharArray());
        SecretKeyFactory secretKeyFactory = SecretKeyFactory.getInstance(encryptPKInfo.getAlgName());
        KeyFactory keyFactory = KeyFactory.getInstance("RSA");

        // Decrypt the private key
        Cipher pbeCipher = Cipher.getInstance(encryptPKInfo.getAlgName());
        pbeCipher.init(Cipher.DECRYPT_MODE, secretKeyFactory.generateSecret(pbeKeySpec), encryptPKInfo.getAlgParameters());
        PKCS8EncodedKeySpec pkcs8EncodedKeySpec = new PKCS8EncodedKeySpec(pbeCipher.doFinal(encryptPKInfo.getEncryptedData()));

        return keyFactory.generatePrivate(pkcs8EncodedKeySpec);
    }

    public static void main(String[] args) throws Exception {
        String passphrase = "your-passphrase";
        String PRIVATE_KEY_FILE_RSA = "src/pri.der";
        File encryptedPrivateKeyFile = new File(PRIVATE_KEY_FILE_RSA);

        PrivateKey privateKey = loadPrivateKey(encryptedPrivateKeyFile, passphrase);
        System.out.println(privateKey);
    }
}