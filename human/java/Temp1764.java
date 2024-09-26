import java.security.SecureRandom;

public class Temp1764 {
    public static void main(String[] args) {
        // Simulating the command line arguments that would be passed to the RandTest class.
        // Since we don't have the actual RandTest class, creating a simple random number generator as an example.

        SecureRandom secureRandom = new SecureRandom();
        int randomNumber = secureRandom.nextInt(100); // Generate a random number between 0 and 99
        System.out.println("Random number: " + randomNumber);

        // If RandTest is an actual existing class, you would invoke it here, but since it's not provided,
        // this is a placeholder to make the code executable.

        // Example of how you might call RandTest if it were available:
        // RandTest.main(args);
    }
}