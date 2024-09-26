import java.util.Arrays;

public class Temp881 {
    public static boolean compareDigests(byte[] digest1, byte[] digest2) {
        return Arrays.equals(digest1, digest2);
    }

    public static void main(String[] args) {
        byte[] digest1 = {1, 2, 3, 4};
        byte[] digest2 = {1, 2, 3, 4};
        boolean result = compareDigests(digest1, digest2);
        System.out.println(result); // This will print: true
    }
}