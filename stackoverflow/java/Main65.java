import javax.crypto.spec.IvParameterSpec;
import java.util.Base64;

public class Main65 {
    public static void main(String[] args) {
        String initVector = "yourInitVectorHere"; // Replace with actual init vector
        IvParameterSpec iv = new IvParameterSpec(Base64.getDecoder().decode(initVector));
        // Rest of your code...
    }
}