import java.util.Arrays;

public class Temp1297 {
    public static void main(String String[]) {
        byte[] ctBytes = new byte[32]; // Dummy initialization for demonstration
        Arrays.fill(ctBytes, (byte) 1); // Fill the array with dummy values

        byte[] saltBytes = Arrays.copyOfRange(ctBytes, 8, 16);
        byte[] ciphertextBytes = Arrays.copyOfRange(ctBytes, 16, ctBytes.length);

        // Printing to verify the values
        System.out.println("Salt Bytes: " + Arrays.toString(saltBytes));
        System.out.println("Ciphertext Bytes: " + Arrays.toString(ciphertextBytes));
    }
}