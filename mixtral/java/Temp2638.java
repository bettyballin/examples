import java.util.Base64;

public class Temp2638 {
    public static void main(String[] args) {
        String publicKeyString = "ssh-rsa AAAAB3Nza..."; // Add your actual public key string here
        byte[] publicKeyBytes;

        String[] parts = publicKeyString.split("\\s+");
        if (parts.length < 2) {
            throw new IllegalArgumentException("Invalid SSH Public Key format.");
        }

        publicKeyBytes = Base64.getDecoder().decode(parts[1]);
        // Optionally, do something with publicKeyBytes
    }
}