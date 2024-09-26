import java.util.UUID;
import java.security.SecureRandom;
import java.util.Random;

public class Temp1967 {
    public static void main(String[] args) {
        Temp1967 temp = new Temp1967();
        System.out.println("Client ID: " + temp.generateClientId());
        System.out.println("Client Secret: " + temp.generateClientSecret(16));
    }

    public String generateClientId() {
        return UUID.randomUUID().toString();
    }

    public String generateClientSecret(int length) {
        SecureRandom random = new SecureRandom();
        StringBuilder sb = new StringBuilder();
        String chars = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789";

        for (int i = 0; i < length; ++i) {
            int rndCharAt = random.nextInt(chars.length());
            sb.append(chars.charAt(rndCharAt));
        }

        return sb.toString();
    }
}