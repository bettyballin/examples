import java.security.SecureRandom;

public class RandomCodeGenerator {
    public static String createRandomCode(int length, String alphabet) {
        SecureRandom random = new SecureRandom();
        StringBuilder builder = new StringBuilder(length);
        for (int i = 0; i < length; i++) {
            builder.append(alphabet.charAt(random.nextInt(alphabet.length())));
        }
        return builder.toString();
    }

    public static void main(String[] args) {
        int length = 10; // Example length
        String randomCode = createRandomCode(length, "ABCDEFGHIJKLMNOPQRSTUVWXYZ");
        System.out.println(randomCode);
    }
}