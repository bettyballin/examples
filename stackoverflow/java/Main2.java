import javax.crypto.Cipher;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.AlgorithmParameters;
import java.nio.charset.StandardCharsets;

public class Main2 {
    public static void main(String[] args) throws Exception {
        // Assuming 'secret' is a valid Key instance
        // Key secret = ...;

        Cipher cipher = Cipher.getInstance("AES/CBC/PKCS5Padding");
        cipher.init(Cipher.ENCRYPT_MODE, secret);
        AlgorithmParameters params = cipher.getParameters();
        byte[] iv = params.getParameterSpec(IvParameterSpec.class).getIV();
        byte[] ciphertext = cipher.doFinal("Hello, World!".getBytes(StandardCharsets.UTF_8));
    }
}