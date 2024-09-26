import javax.crypto.Cipher;
import javax.crypto.spec.OAEPParameterSpec;
import javax.crypto.spec.PSource;
import java.security.KeyPair;
import java.security.KeyPairGenerator;
import java.security.interfaces.RSAPublicKey;
import java.security.spec.MGF1ParameterSpec;

public class Temp1341 {
    public static void main(String[] args) throws Exception {
        // Generate a key pair for RSA encryption
        KeyPairGenerator kpg = KeyPairGenerator.getInstance("RSA");
        kpg.initialize(2048);
        KeyPair keyPair = kpg.generateKeyPair();
        RSAPublicKey publicKey = (RSAPublicKey) keyPair.getPublic();

        // Create an OAEPParameterSpec object with your custom label value
        String myLabel = "my-label-value";
        OAEPParameterSpec oaepParams = new OAEPParameterSpec(
                "SHA-256",
                "MGF1",
                MGF1ParameterSpec.SHA256,
                PSource.PSpecified.DEFAULT
        );

        // Initialize the Cipher object with RSA/ECB/OAEPWithSHA-256AndMGF1Padding and your custom OAEP parameters
        Cipher cipher = Cipher.getInstance("RSA/ECB/OAEPWithSHA-256AndMGF1Padding");
        cipher.init(Cipher.ENCRYPT_MODE, publicKey, oaepParams);

        // Encrypt some data using the initialized Cipher object
        byte[] plaintext = "Hello world!".getBytes();
        byte[] ciphertext = cipher.doFinal(plaintext);

        // Print ciphertext in hexadecimal format
        StringBuilder sb = new StringBuilder();
        for (byte b : ciphertext) {
            sb.append(String.format("%02X ", b));
        }
        System.out.println("Ciphertext: " + sb.toString());
    }
}