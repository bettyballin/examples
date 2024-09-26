public class Temp1295 {
    public static void main(String[] args) {
        int[] wordArray = new int[] {0x53616c74, 0x65645f5f};
        int[] salt = new int[] {0x12345678, 0x9abcdef0}; // Example salt array
        int[] ciphertext = new int[] {0xabcdef12, 0x34567890}; // Example ciphertext array

        int[] combinedArray = concat(wordArray, salt);
        combinedArray = concat(combinedArray, ciphertext);

        for (int i : combinedArray) {
            System.out.printf("0x%08X ", i);
        }
    }

    public static int[] concat(int[] first, int[] second) {
        int[] result = new int[first.length + second.length];
        System.arraycopy(first, 0, result, 0, first.length);
        System.arraycopy(second, 0, result, first.length, second.length);
        return result;
    }
}