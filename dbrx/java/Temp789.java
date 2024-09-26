import java.security.SecureRandom;

public class Temp789 {
    public static void main(String[] args) {
        String result = createRandomCode(10);
        System.out.println(result); // prints something like "KJHGFDSWER"
    }

    public static String createRandomCode(int length) {
        String chars = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        SecureRandom random = new SecureRandom();
        StringBuilder code = new StringBuilder(length);

        for (int i = 0; i < length; i++) {
            code.append(chars.charAt(random.nextInt(chars.length())));
        }

        return code.toString();
    }
}