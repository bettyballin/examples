import java.security.KeyFactory;
import java.security.PublicKey;
import java.security.spec.X509EncodedKeySpec;
import java.util.Base64;
import javax.crypto.Cipher;
import org.bouncycastle.jce.provider.BouncyCastleProvider;

public class Temp1381 {
    public static void main(String[] args) {
        try {
            String originalString = "Hello, World!";
            String serverPublicKeyBase64 = "your_server_public_key_base64_here";
            byte[] encryptedData = clientSideCodeToGenerateEncryptedData(originalString, serverPublicKeyBase64);
            System.out.println(new String(encryptedData));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static byte[] clientSideCodeToGenerateEncryptedData(String originalString, String serverPublicKeyBase64) throws Exception {
        Cipher cipher = Cipher.getInstance("EC", new BouncyCastleProvider());

        KeyFactory keyFac = KeyFactory.getInstance("EC", new BouncyCastleProvider());

        byte[] decodedServerPubkeyBytes = Base64.getDecoder().decode(serverPublicKeyBase64);

        PublicKey serverPublicKey = keyFac.generatePublic(new X509EncodedKeySpec(decodedServerPubkeyBytes));

        cipher.init(Cipher.ENCRYPT_MODE, serverPublicKey);

        byte[] encryptedBase64Data = Base64.getEncoder().encode(cipher.doFinal(originalString.getBytes("UTF-8")));

        return encryptedBase64Data;
    }
}