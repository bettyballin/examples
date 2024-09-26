import javax.crypto.spec.OAEPParameterSpec;
import javax.crypto.spec.PSource;
import javax.crypto.spec.MGF1ParameterSpec;

public class Main89 {
    public static void main(String[] args) {
        OAEPParameterSpec oaepParams = new OAEPParameterSpec("SHA-1", "MGF1", MGF1ParameterSpec.SHA1, PSource.PSpecified.DEFAULT);
    }
}