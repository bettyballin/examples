import java.util.Arrays;

public class Temp837 {
    public static void main(String[] args) {
        char[] password = {'p', 'a', 's', 's', 'w', 'o', 'r', 'd'};
        // Use the char array here

        Arrays.fill(password, '\u0000'); // Overwrite all elements with 0
        System.out.println(Arrays.toString(password)); // Just to avoid "password" being unused.
    }
}