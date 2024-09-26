import javax.crypto.Cipher;
import javax.crypto.spec.IvParameterSpec;
import java.security.AlgorithmParameterSpec;
import java.security.SecureRandom;

public class Temp659 {

    private Cipher cipher;

    public Temp659() throws Exception {
        // Initialize the cipher for demonstration purposes.
        this.cipher = Cipher.getInstance("AES/CBC/PKCS5Padding");
    }

    public static void main(String[] args) {
        try {
            Temp659 temp = new Temp659();
            AlgorithmParameterSpec ivSpec = temp.getIV();
            System.out.println("IV Spec: " + ivSpec);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public AlgorithmParameterSpec getIV() {
        AlgorithmParameterSpec ivspec;
        byte[] iv = new byte[cipher.getBlockSize()];
        new SecureRandom().nextBytes(iv);
        ivspec = new IvParameterSpec(iv);
        return ivspec;
    }
}