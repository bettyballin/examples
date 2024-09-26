import java.util.Arrays;

public class Temp1192 {
    public static void main(String[] args) {

        // Store sensitive information in char[]
        char[] password = {'p', 'a', 's', 's', 'w', 'o', 'r', 'd'};

        // Clear the data
        Arrays.fill(password, '\0');

        // Nullify reference
        password = null;
    }
}