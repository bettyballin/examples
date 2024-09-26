import java.util.Random;

public class Temp333 {
    public static void main(String[] args) {
        Random random = new Random();
        int keyInt = random.nextInt(Integer.MAX_VALUE);
        String decKey = String.valueOf(keyInt);
        System.out.println(decKey);
    }
}