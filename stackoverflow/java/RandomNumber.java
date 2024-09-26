import java.util.Random;

public class RandomNumber {
    public static void main(String[] args) {
        Random rand = new Random();
        // 0 inclusive to 100 exclusive.
        int number = rand.nextInt(100);
        System.out.println(number);
    }
}