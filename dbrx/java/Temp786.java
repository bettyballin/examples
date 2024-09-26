import java.nio.file.Files;
import java.nio.file.Paths;
import java.security.KeyFactory;
import java.security.PublicKey;
import java.security.spec.X509EncodedKeySpec;
import java.util.Base64;

public class Main {

    public static void main(String[] args) throws Exception {
        String idRsaPubContent = readFile("/path/to/id_rsa.pub");
        byte[] base64Bytes = extractBase64(idRsaPubContent);
        PublicKey test1 = base64ToPublicKey("RSA", base64Bytes);
    }

    private static String readFile(String path) throws Exception {
        return new String(Files.readAllBytes(Paths.get(path)));
    }

    private static byte[] extractBase64(String key) {
        String publicKeyPEM = key.replace("-----BEGIN PUBLIC KEY-----", "")
                                 .replace("-----END PUBLIC KEY-----", "")
                                 .replaceAll("\\s+", "");
        return Base64.getDecoder().decode(publicKeyPEM);
    }

    private static PublicKey base64ToPublicKey(String algorithm, byte[] base64) throws Exception {
        X509EncodedKeySpec spec = new X509EncodedKeySpec(base64);
        KeyFactory keyFactory = KeyFactory.getInstance(algorithm);
        return keyFactory.generatePublic(spec);
    }
}