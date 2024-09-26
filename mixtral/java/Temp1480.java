import java.security.SecureRandom;

public class Temp1480 {
    public static void main(String[] args) {
        SecureRandom randomNumberGenerator = new SecureRandom();
        int maxValue = 10;
        int minValue = 1;

        // Generate a secure random number between [min max]
        int magic = randomNumberGenerator.nextInt(maxValue - minValue + 1) + minValue;
        
        // Print the generated number
        System.out.println("Generated secure random number: " + magic);
    }
}