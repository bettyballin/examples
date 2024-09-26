import java.util.Random;

public class Temp1920 {
    public static void main(String[] args) {
        int length = 10; // Define a length for the random code
        String randomCode = createRandomCode(length, "ABCDEFGHIJKLMNOPQRSTUVWXYZ");
        System.out.println(randomCode);
    }

    public static String createRandomCode(int length, String characters) {
        Random random = new Random();
        StringBuilder code = new StringBuilder(length);
        for (int i = 0; i < length; i++) {
            code.append(characters.charAt(random.nextInt(characters.length())));
        }
        return code.toString();
    }
}