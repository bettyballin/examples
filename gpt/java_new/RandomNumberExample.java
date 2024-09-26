import java.security.SecureRandom;

public class RandomNumberExample {
    private static void generateNumber() {
        SecureRandom secureRandom = new SecureRandom();
        int magic = secureRandom.nextInt(10) + 1;
        String x;
        switch (magic) {
            case 1:
                x = "Yes.";
                break;
            case 2:
                x = "No.";
                break;
            // ... (other cases if necessary)
            default:
                x = "Try Again.";
                break;
        }
        System.out.println(x);
    }

    public static void main(String[] args) {
        generateNumber();
    }
}