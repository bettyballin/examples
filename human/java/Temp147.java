import java.util.HashMap;
import java.util.Map;

public class Temp147 {
    public static void main(String[] args) {
        Map<String, String> signingProps = new HashMap<>();
        signingProps.put("WSHandlerConstants.ENABLE_SIGNATURE_CONFIRMATION", "true");

        // Printing to verify the content
        System.out.println(signingProps);
    }
}