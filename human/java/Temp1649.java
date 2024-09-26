import java.util.Arrays;

public class Temp1649 {
    public static void main(String[] args) {
        // Example digests for demonstration purposes
        byte[] digest1 = {1, 2, 3, 4, 5};
        byte[] digest2 = {1, 2, 3, 4, 5};

        // Check if digest1 equals digest2
        boolean result = Arrays.equals(digest1, digest2);
        System.out.println("Digests are equal: " + result);
    }
}