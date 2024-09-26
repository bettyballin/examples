import java.security.SecureRandom;

public class Temp788 {
    public static void main(String[] args) {
        Temp788 temp = new Temp788();
        temp.createRandomCode(10, 123);
    }

    public String createRandomCode(int codeLength, int id) {
        StringBuilder sb = new StringBuilder();
        SecureRandom random = new SecureRandom();
        for (int i = 0; i < codeLength; i++) {
            char c = (char) (random.nextInt(26) + 'A');
            sb.append(c);
        }
        String output = sb.toString();
        System.out.println(output);
        return output;
    }
}