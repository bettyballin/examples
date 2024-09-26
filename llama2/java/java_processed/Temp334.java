import java.util.Random;

public class Temp334 {
    public static void main(String[] args) {
        Random random = new Random();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < 8; i++) {
            int nextInt = random.nextInt(16);
            String hex = Integer.toHexString(nextInt).toLowerCase();
            sb.append(hex.length() == 1 ? "0" + hex : hex);
        }
        String hexKey = sb.toString();
        System.out.println(hexKey);
    }
}