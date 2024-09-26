import java.security.SecureRandom;

public class Temp2340 {
    public static void main(String[] args) {
        int[] generatedId = getId(4);
        System.out.print("Generated ID: ");
        for (int num : generatedId) {
            System.out.print(num + " ");
        }
    }

    public static int[] getId(int length) {
        SecureRandom secureRandom = new SecureRandom();
        int[] buf = new int[length];

        // Fill buffer with random bytes
        for (int i = 0; i < length; i++) {
            buf[i] = secureRandom.nextInt(256); // 0 to 255
        }

        return buf;
    }
}