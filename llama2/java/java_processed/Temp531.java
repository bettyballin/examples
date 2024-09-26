import java.security.spec.MGF1ParameterSpec;
import java.security.spec.OAEPParameterSpec;
import javax.crypto.spec.PSource;

public class Temp531 {
    public static void main(String[] args) {
        final OAEPParameterSpec oaepParams = new OAEPParameterSpec(
                "SHA-512",
                "MGF1",
                MGF1ParameterSpec.SHA1,
                PSource.PSpecified.DEFAULT
        );
        System.out.println("OAEP Parameters: " + oaepParams);
    }
}