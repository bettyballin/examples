import java.util.Arrays;

public class Temp595 {

    public static void main(String[] args) {
        Temp595 myObject = new Temp595();
        char[] password = myObject.getPassword();

        try {
            // Use this array immediately for authentication or any other purpose
            System.out.println(password); // Example usage
        } finally {
            Arrays.fill(password, '0');
        }
    }

    public char[] getPassword() {
        // This is just a placeholder for the actual password fetching logic
        // Replace this with the actual password field retrieval logic
        return "examplePassword".toCharArray();
    }
}