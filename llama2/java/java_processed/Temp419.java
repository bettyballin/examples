import java.util.Random;

public class Temp419 {
    public static void main(String[] args) {
        Random random = new Random();
        int randomInt = random.nextInt(100); // Generate a random integer between 0 and 99

        switch (randomInt % 10) {
            case 0:
                System.out.println("Case 0");
                break;
            case 1:
                System.out.println("Case 1");
                break;
            default:
                System.out.println("Default case");
                break;
        }
    }
}