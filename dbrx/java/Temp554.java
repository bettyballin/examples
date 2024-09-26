import java.util.Base64;

public class Temp554 {
    public static void main(String[] args) {
        String encryptedData = "U29tZVN0cmluZzpTb21lQ2lwaGVyRGF0YQ=="; // Example encrypted data

        String decodedData = new String(Base64.getDecoder().decode(encryptedData));
        String[] parts = decodedData.split(":");
        if (parts.length != 2) {
            System.out.println("Invalid encrypted data format");
            return;
        }

        byte[] saltBytes = parts[0].getBytes();
        byte[] cipherBytes = parts[1].getBytes();

        // Output the decoded bytes for demonstration
        System.out.println("Salt bytes: " + new String(saltBytes));
        System.out.println("Cipher bytes: " + new String(cipherBytes));
    }
}