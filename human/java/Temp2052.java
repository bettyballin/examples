import java.security.KeyFactory;
import java.security.PrivateKey;
import java.security.spec.PKCS8EncodedKeySpec;
import java.util.Base64;
import org.bouncycastle.util.Arrays;
import org.bouncycastle.util.encoders.Hex;

public class Temp2052 {
    public static void main(String[] args) {
        try {
            // static header you can put in front
            byte[] header = Hex.decode("3081bf020100301006072a8648ce3d020106052b810400220481a7");
            
            // your key from the PEM above
            byte[] fromPEM = Base64.getDecoder().decode("MIGkAgEBBDD2MFRv6BpJU6/zDI2yBfVbe0oeU1nFAoYMedDGtcdwHyWNJSeiYRBApVNzMxPSBLWgBwYFK4EEACKhZANiAAQBttEp/qUGnDlmL+o6KZnVs+RoBnEBEGhoPxSUu1Xfj77QQqfuqHOCRzWXseQA1aZB/h6VQEiFovugtG1G3HaMxxrqLLxb10g2BMaRcAfZyeqc3O0Ui8XXb1esn0gOrCU=");
            
            byte[] bytes = Arrays.concatenate(header, fromPEM);
            PrivateKey ecPrivate = KeyFactory.getInstance("EC").generatePrivate(new PKCS8EncodedKeySpec(bytes));
            
            System.out.println("Private Key: " + ecPrivate);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}


To execute this code, make sure you have the BouncyCastle library included in your classpath. You can download it from the BouncyCastle website or add it to your project via Maven or Gradle.