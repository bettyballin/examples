import java.security.*;
import java.security.cert.CertificateException;
import java.security.cert.X509Certificate;

public class Temp1234 {
    public static void main(String[] args) throws NoSuchAlgorithmException, NoSuchProviderException, InvalidKeyException, SignatureException {
        // Sample data for demonstration
        String data = "Sample data to sign";
        byte[] byteData = data.getBytes();

        // Generate a key pair for demonstration
        KeyPairGenerator keyGen = KeyPairGenerator.getInstance("RSA");
        keyGen.initialize(2048, new SecureRandom());
        KeyPair keyPair = keyGen.generateKeyPair();
        PrivateKey privateKey = keyPair.getPrivate();
        PublicKey publicKey = keyPair.getPublic();

        Signature signature = Signature.getInstance("SHA256withRSA");
        System.out.println("signature.getProvider():" + signature.getProvider());
        signature.initSign(privateKey, new SecureRandom());
        signature.update(byteData);
        byte[] signatureBytes = signature.sign();
        System.out.println("signatureBytes: " + new String(signatureBytes));

        // Verification
        Signature signature1 = Signature.getInstance("SHA256withRSA");
        System.out.println("signature1.getProvider():" + signature1.getProvider());
        signature1.initVerify(publicKey);
        signature1.update(byteData);

        boolean verifies = signature1.verify(signatureBytes);
        System.out.println("signature verifies: " + verifies);
    }
}