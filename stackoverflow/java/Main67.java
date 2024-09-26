import org.bouncycastle.util.encoders.Hex;
import org.bouncycastle.util.encoders.Base64;
import org.bouncycastle.util.Arrays;
import java.security.KeyFactory;
import java.security.PrivateKey;
import java.security.spec.PKCS8EncodedKeySpec;

public class Main67 {
    public static void main(String[] args) throws Exception {
        // static header you can put in front
        byte[] header = Hex.decode("3081bf020100301006072a8648ce3d020106052b810400220481a7");
        // your key from the PEM above
        byte[] fromPEM = Base64.decode(
            "MIGkAgEBBDD2MFRv6BpJU6/zDI2yBfVbe0oeU1nFAoYMedDGtcdwHyWNJSeiYRBApVNzMxPSBLWg" +
            "BwYFK4EEACKhZANiAAQBttEp/qUGnDlmL+o6KZnVs+RoBnEBEGhoPxSUu1Xfj77QQqfuqHOCRzWX" +
            "seQA1aZB/h6VQEiFovugtG1G3HaMxxrqLLxb10g2BMaRcAfZyeqc3O0Ui8XXb1esn0gOrCU=");
        byte[] bytes = Arrays.concatenate(header, fromPEM);
        PrivateKey ecPrivate = KeyFactory.getInstance("EC").generatePrivate(new PKCS8EncodedKeySpec(bytes));
    }
}