import java.security.*;
import java.util.Base64;

public class Temp680 {
    public static void main(String[] args) {
        try {
            // Example data
            String data = "example data";
            String signatureBase64 = "base64encodedsignature";
            String publicKeyBase64 = "base64encodedpublickey";

            // Convert data to byte array
            byte[] dataThatWasSigned = data.getBytes();

            // Decode the base64 encoded signature and public key
            byte[] signatureYouReceived = Base64.getDecoder().decode(signatureBase64);
            byte[] publicKeyBytes = Base64.getDecoder().decode(publicKeyBase64);

            // Generate public key from bytes
            X509EncodedKeySpec keySpec = new X509EncodedKeySpec(publicKeyBytes);
            KeyFactory keyFactory = KeyFactory.getInstance("RSA");
            PublicKey publicKey = keyFactory.generatePublic(keySpec);

            // Initialize the signature
            Signature sig = Signature.getInstance("SHA256withRSA");
            sig.initVerify(publicKey);
            sig.update(dataThatWasSigned);

            // Verify the signature
            boolean validSignature = sig.verify(signatureYouReceived);
            System.out.println("Signature valid: " + validSignature);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}