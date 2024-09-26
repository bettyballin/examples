import java.security.*;
import java.security.spec.PKCS8EncodedKeySpec;
import java.security.spec.X509EncodedKeySpec;
import java.util.Base64;

public class Temp1543 {
    public static void main(String[] args) {
        try {
            String dataToSign = "Your data to sign";
            String privateKeyPEM = "YOUR_PRIVATE_KEY_HERE";
            String publicKeyPEM = "YOUR_PUBLIC_KEY_HERE";

            // Remove the first and last lines
            privateKeyPEM = privateKeyPEM.replace("-----BEGIN PRIVATE KEY-----", "").replace("-----END PRIVATE KEY-----", "").replaceAll("\\s", "");
            publicKeyPEM = publicKeyPEM.replace("-----BEGIN PUBLIC KEY-----", "").replace("-----END PUBLIC KEY-----", "").replaceAll("\\s", "");

            // Base64 decode the data
            byte[] privateKeyBytes = Base64.getDecoder().decode(privateKeyPEM);
            byte[] publicKeyBytes = Base64.getDecoder().decode(publicKeyPEM);

            PKCS8EncodedKeySpec keySpecPrivate = new PKCS8EncodedKeySpec(privateKeyBytes);
            X509EncodedKeySpec keySpecPublic = new X509EncodedKeySpec(publicKeyBytes);

            KeyFactory keyFactory = KeyFactory.getInstance("RSA");

            PrivateKey privateKey = keyFactory.generatePrivate(keySpecPrivate);
            PublicKey publicKey = keyFactory.generatePublic(keySpecPublic);

            // Sign the data
            Signature signature = Signature.getInstance("SHA1withRSA");
            signature.initSign(privateKey);
            signature.update(dataToSign.getBytes());

            byte[] signedData = signature.sign();

            System.out.println("Signature: " + Base64.getEncoder().encodeToString(signedData));

            // Verify the signature
            signature.initVerify(publicKey);
            signature.update(dataToSign.getBytes());

            boolean isVerified = signature.verify(signedData);

            System.out.println("Signature verified: " + isVerified);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}