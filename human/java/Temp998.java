import java.util.Base64;

public class Temp998 {
    public static void main(String[] args) {
        byte[] encryptedData = encryptData("Confidential data"); // String from user
        String s = Base64.getEncoder().encodeToString(encryptedData); // Encode byte array to Base64 string
        byte[] bb = Base64.getDecoder().decode(s); // Decode Base64 string back to byte array

        // For demonstration, print out the original and decoded data to verify
        System.out.println("Original encrypted data: " + new String(encryptedData));
        System.out.println("Decoded data: " + new String(bb));
    }

    // Dummy encryption method for demonstration purposes
    public static byte[] encryptData(String data) {
        return data.getBytes(); // In a real scenario, use proper encryption here
    }
}