import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.security.GeneralSecurityException;
import java.security.KeyFactory;
import java.security.PrivateKey;
import java.security.Signature;
import java.security.spec.PKCS8EncodedKeySpec;
import java.util.Base64;

public class Temp3576 {
    public static void main(String[] args) {
        try {
            String signature = sign("Your string to sign");
            System.out.println(signature);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static String sign(String string) throws IOException, GeneralSecurityException {
        String path = "path/to/WM_IO_private_key";
        String key = new String(Files.readAllBytes(Paths.get(path)))
                .replace("-----BEGIN RSA PRIVATE KEY-----", "")
                .replace("-----END RSA PRIVATE KEY-----", "")
                .replace("\n", "");

        byte[] derData = Base64.getDecoder().decode(key);

        PKCS8EncodedKeySpec keySpec = new PKCS8EncodedKeySpec(derData);
        KeyFactory keyFactory = KeyFactory.getInstance("RSA");
        PrivateKey privateKey = keyFactory.generatePrivate(keySpec);

        Signature signature = Signature.getInstance("SHA256withRSA");
        signature.initSign(privateKey);
        signature.update(string.getBytes());

        byte[] signedData = signature.sign();
        return Base64.getEncoder().encodeToString(signedData);
    }
}