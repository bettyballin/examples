import javax.crypto.Cipher;
import javax.crypto.NoSuchPaddingException;
import java.security.InvalidKeyException;
import java.security.KeyFactory;
import java.security.NoSuchAlgorithmException;
import java.security.PrivateKey;
import java.security.spec.PKCS8EncodedKeySpec;
import java.util.Base64;

public class Temp88 {
    public static void main(String[] args) {
        byte[] input = "Your input data".getBytes();
        String privateKeyPEM = "Your private key in PEM format without the headers";
        try {
            // Decode the PEM formatted private key
            byte[] keyBytes = Base64.getDecoder().decode(privateKeyPEM);

            // Create private key
            PKCS8EncodedKeySpec keySpec = new PKCS8EncodedKeySpec(keyBytes);
            KeyFactory keyFactory = KeyFactory.getInstance("RSA");
            PrivateKey privateKey = keyFactory.generatePrivate(keySpec);

            // Initialize the cipher
            Cipher cipher = Cipher.getInstance("RSA/ECB/PKCS1Padding");
            cipher.init(Cipher.DECRYPT_MODE, privateKey);

            // Decrypt the data
            byte[] signature = new byte[cipher.getOutputSize(input.length)];
            int outputLen = 0;
            for (int i = 0; i < input.length; ) {
                int len = Math.min(128, input.length - i); // process data in chunks
                outputLen += cipher.update(input, i, len, signature, outputLen);
                i += len;
            }
            outputLen += cipher.doFinal(signature, outputLen);
            byte[] finalSignature = new byte[outputLen];
            System.arraycopy(signature, 0, finalSignature, 0, outputLen);

            // Process final signature as needed
        } catch (InvalidKeyException e) {
            // Handle invalid key exception here
            e.printStackTrace();
        } catch (NoSuchAlgorithmException e) {
            // Handle no such algorithm exception here
            e.printStackTrace();
        } catch (NoSuchPaddingException e) {
            // Handle no such padding exception here
            e.printStackTrace();
        } catch (Exception e) {
            // Handle other exceptions here
            e.printStackTrace();
        }
    }
}