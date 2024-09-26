import java.nio.charset.Charset;
import java.security.PrivateKey;
import java.security.Signature;
import java.util.Base64;

public class Temp1465 {
    public static void main(String[] args) {
        // Example usage (requires actual PrivateKey and PublicKey implementations)
        try {
            PrivateKey privateKey = null; // Replace with actual private key
            String xmlSolicitud = "<example>Request</example>";
            String encrypted = encriptar(xmlSolicitud, privateKey);
            System.out.println("Encrypted: " + encrypted);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static String encriptar(String xmlSolicitud, PrivateKey privateKey)
            throws Exception {
        Signature signature = Signature.getInstance("SHA1withRSA");
        signature.initSign(privateKey);
        signature.update(xmlSolicitud.getBytes(Charset.forName("UTF-8")));

        byte[] signatureValue = signature.sign();
        String response = Base64.getEncoder().encodeToString(signatureValue);

        // Assuming keyReader and Reference are defined and implemented elsewhere
        // signature.initVerify(keyReader.publicKeyRead(Reference.rutaPublicKeyTest));
        // signature.update(xmlSolicitud.getBytes(Charset.forName("UTF-8")));
        // System.out.println(signature.verify(signatureValue));

        return response;
    }
}