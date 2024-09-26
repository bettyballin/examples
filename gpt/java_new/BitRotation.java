public class BitRotation {
    public static void main(String[] args) {
        long keyUpper = 0xFFFFFFFFFFFFFFFFL; // your upper 64 bits
        long keyLower = 0xFFFFFFFFFFFFFFFFL; // your lower 64 bits

        // Rotate the lower bits
        keyLower = (keyLower >>> 29) | (keyUpper << 35);

        // Rotate the upper bits
        keyUpper = (keyUpper >>> 29) | (keyLower << 35);

        System.out.println("Rotated Upper: " + Long.toBinaryString(keyUpper));
        System.out.println("Rotated Lower: " + Long.toBinaryString(keyLower));
    }
}