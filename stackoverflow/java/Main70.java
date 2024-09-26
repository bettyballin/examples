import java.util.Base64;

public class Main70 {
    public static void main(String[] args) {
        byte[] encryptedMessage = "Your encrypted message goes here".getBytes(); // Replace with actual encrypted message bytes
        System.out.println(Base64.getEncoder().encodeToString(encryptedMessage));
    }
}