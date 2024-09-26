import java.security.*;
import java.security.spec.MGF1ParameterSpec;
import java.security.spec.PSSParameterSpec;
import org.bouncycastle.jcajce.provider.asymmetric.rsa.PSSSignatureSpi;
import org.bouncycastle.jcajce.provider.asymmetric.rsa.RSABlindedEngine;

public class SHA256withRSACustomPadding extends PSSSignatureSpi {
    public SHA256withRSACustomPadding(int padding) {
        super(new RSABlindedEngine(), new PSSParameterSpec("SHA-256", "MGF1", new MGF1ParameterSpec("SHA-256"), padding, 1));
    }

    public void initSign(PrivateKey privateKey) throws InvalidKeyException {
        engineInitSign(privateKey);
    }

    public void update(byte[] data) throws SignatureException {
        engineUpdate(data,0,data.length);
    }

    public byte[] sign() throws SignatureException {
        return engineSign();
    }

    public void initVerify(PublicKey publicKey) throws InvalidKeyException {
        engineInitVerify(publicKey);
    }

    public boolean verify(byte[] data) throws SignatureException {
        return engineVerify(data);
    }

    public static void main(String[] args) {
        try {
            // Generate a key pair
            KeyPairGenerator keyGen = KeyPairGenerator.getInstance("RSA");
            keyGen.initialize(2048);
            KeyPair keyPair = keyGen.generateKeyPair();

            // Create an instance of the custom signature class
            SHA256withRSACustomPadding signature = new SHA256withRSACustomPadding(32);

            // Initialize for signing
            signature.initSign(keyPair.getPrivate());

            // Update the data to be signed
            byte[] data = "Hello, World!".getBytes();
            signature.update(data);

            // Sign the data
            byte[] signedData = signature.sign();

            // Initialize for verification
            signature.initVerify(keyPair.getPublic());

            // Verify the signature
            boolean verified = signature.verify(signedData);

            // Print the result
            System.out.println("Signature verified: " + verified);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}