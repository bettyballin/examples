public class Temp843 {
    public static void main(String[] args) {
        // Original code had invalid hex literals. Assuming the intention was to declare an array of zeroes.
        int[] array = new int[16];
        for (int value : array) {
            System.out.printf("0x%02X ", value);
        }
    }
}