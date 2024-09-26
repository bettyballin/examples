import java.io.*;
import java.nio.file.*;
import java.security.*;
import java.security.spec.*;

public class SignatureExample {
    public static void main(String[] args) {
        try {
            File privateKeyFile = new File("path to .pem file");
            PrivateKey privateKey = loadPrivateKey(privateKeyFile);

            Signature signature = Signature.getInstance("SHA256withRSA");
            signature.initSign(privateKey);
            signature.update("data to sign".getBytes());

            byte[] signatureBytes = signature.sign();
            System.out.println(Base64.getEncoder().encodeToString(signatureBytes));
        } catch (IOException | NoSuchAlgorithmException | InvalidKeyException | SignatureException | InvalidKeySpecException e) {
            e.printStackTrace();
        }
    }

    private static PrivateKey loadPrivateKey(File file) throws IOException, NoSuchAlgorithmException, InvalidKeySpecException {
        byte[] keyBytes = Files.readAllBytes(file.toPath());
        PKCS8EncodedKeySpec spec = new PKCS8EncodedKeySpec(keyBytes);
        KeyFactory kf = KeyFactory.getInstance("RSA");
        return kf.generatePrivate(spec);
    }
}