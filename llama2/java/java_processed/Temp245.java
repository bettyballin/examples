import java.util.Arrays;

public class Temp245 {
    public static void main(String[] args) {
        byte[] key = {1, 2, 3, 4}; // Example key, you can replace it with your own key
        byte[] paddedKey = Arrays.copyOf(key, key.length + (8 - (key.length % 8)));
        
        // Printing the padded key for verification
        System.out.println(Arrays.toString(paddedKey));
    }
}