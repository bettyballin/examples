import java.security.SecureRandom;
import java.util.Random;

public class Temp1098 {
    public static void main(String[] args) {
        Temp1098 temp = new Temp1098();
        temp.createRandomCode(10); // Example length
    }

    public String createRandomCode(int length) {
        StringBuilder sb = new StringBuilder();
        Random random = new SecureRandom();

        // Define the range of characters to choose from
        final char[] upperCaseLetters = "ABCDEFGHIJKLMNOPQRSTUVWXYZ".toCharArray();

        for (int i = 0; i < length; i++) {
            char c = upperCaseLetters[random.nextInt(upperCaseLetters.length)];
            sb.append(c);
        }

        String output = sb.toString();

        System.out.println(output);

        return output;
    }
}