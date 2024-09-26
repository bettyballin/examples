import java.security.*;
import java.security.spec.*;
import java.util.Base64;

public class Temp530 {
    public static void main(String[] args) {
        try {
            // Assuming encodedPubKey and realSig are defined somewhere
            String encodedPubKey = "your_base64_encoded_public_key_here";
            byte[] realSig = Base64.getDecoder().decode("your_base64_encoded_signature_here");

            // Decode Public Key
            byte[] decodedPubKey = Base64.getDecoder().decode(encodedPubKey);
            X509EncodedKeySpec pubKeySpec = new X509EncodedKeySpec(decodedPubKey);
            KeyFactory keyFactory = KeyFactory.getInstance("EC");
            PublicKey publicKey = keyFactory.generatePublic(pubKeySpec);

            // Verify Signature
            Signature sigVerifier = Signature.getInstance("SHA1withECDSA");
            sigVerifier.initVerify(publicKey);
            String strToVerify = "This is string to sign";
            byte[] byteStrToVerify = strToVerify.getBytes();
            sigVerifier.update(byteStrToVerify);
            boolean verified = sigVerifier.verify(realSig);
            System.out.println("Signature Verified: " + verified);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}