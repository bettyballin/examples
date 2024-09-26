import java.util.HashMap;
import java.util.Map;

public class Temp30 {
    public static void main(String[] args) {
        Map<String, Boolean> signingProps = new HashMap<>();
        signingProps.put("SignatureConfirmation", true);
        System.out.println(signingProps);
    }
}