import java.util.Base64;

public class Temp2318 {
    public static void main(String[] args) {
        String encodedString = "your_base64_encoded_string_here"; // Replace with your actual base64 encoded string

        // Decode the base64 encoded string
        byte[] decodedBytes = Base64.getDecoder().decode(encodedString);

        if (decodedBytes.length > 32) {
            // Extract the first 16 bytes (assuming they are the IV)
            byte[] ivBytes = new byte[16];
            System.arraycopy(decodedBytes, 0, ivBytes, 0, 16);

            // Convert IV bytes to hex string
            StringBuilder ivHexStr = new StringBuilder();
            for (byte b : ivBytes) {
                ivHexStr.append(String.format("%02x", b));
            }

            String ivStr = ivHexStr.toString();
            System.out.println("Extracted IV (hex): " + ivStr);
        }
    }
}