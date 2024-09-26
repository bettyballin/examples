import java.util.Base64;

public class Temp571 {
    public static void main(String[] args) {
        // Example base64 string, replace with actual input
        String challengeBase64 = "SGVsbG8gV29ybGQ=";

        byte[] challengeBytes = Base64.getDecoder().decode(challengeBase64);
        for (int i = 0; i < challengeBytes.length; ++i) {
            if (challengeBytes[i] < 0) {
                // Convert signed byte to unsigned integer
                challengeBytes[i] += 256;
            }
        }
        
        // Print the unsigned byte values for verification
        for (byte b : challengeBytes) {
            System.out.print((b & 0xFF) + " ");
        }
    }
}