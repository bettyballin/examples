import java.math.BigInteger;
import java.util.Base64;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Temp1360 {
    public static void main(String[] args) {
        // This is a placeholder for the actual response object
        // Replace response with the actual response from your API
        Map<String, Object> response = new HashMap<>();
        // Assuming the response body is a map with a "keys" entry
        response.put("keys", List.of(
                Map.of("use", "sig", "kty", "RSA", "n", "some_base64_encoded_value", "e", "another_base64_encoded_value")
        ));

        String kid = "9FXDpbMFfT2SvQuXh846YTwEIBw"; // Replace with actual 'kid' value
        List<Map<String, Object>> keys = (List<Map<String, Object>>) response.get("keys");

        for (Map<String, Object> key : keys) {
            if ("sig".equalsIgnoreCase((String) key.get("use"))) {
                String kty = (String) key.get("kty");

                // RSA
                if ("RSA".equals(kty)) {
                    Map<String, Object> rsaKey = new HashMap<>();

                    BigInteger modulus;

                    try {
                        byte[] nBytes = Base64.getUrlDecoder().decode((String) key.get("n"));

                        // Convert the bytes to a positive integer
                        modulus = new BigInteger(1, nBytes);

                        rsaKey.put("mod", modulus);

                    } catch (Exception e) {
                        e.printStackTrace();
                    }

                    byte[] expBytes;

                    try {
                        // Convert the exponent to a positive integer
                        BigInteger publicExponent = new BigInteger(1, Base64.getUrlDecoder().decode((String) key.get("e")));

                        rsaKey.put("exp", publicExponent);

                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            }
        }
    }
}