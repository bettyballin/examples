import java.security.SecureRandom;

public class Temp1690 {
    public static void main(String[] args) {
        SecureRandom sr = new SecureRandom();
        int value = sr.nextInt();
        System.out.println("Random value: " + value);
    }
}