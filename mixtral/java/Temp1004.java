import java.util.Arrays;

public class Temp1004 {
    public static void main(String[] args) {
        int[] values = {1, 2, 3, 4}; // Example values array
        int[] keys = new int[values.length];
        
        for(int i = 0; i < keys.length; ++i) {
            int b = values[i]; // Assuming b is derived from values array
            keys[i] = (b & 0xFF);
        }
        
        System.out.println("Key: " + Arrays.toString(keys));
    }
}