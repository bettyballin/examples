public class Temp588 {
    public static void main(String[] args) {
        long keyLower = 0x1FFFFFFFFFL; // Example value for keyLower
        long keyUpper = 0x1FFFFFFFFFL; // Example value for keyUpper

        long temp = ((keyLower >>> 35) | (keyUpper << 29)) & 0x7FFFFFFF;
        keyUpper = (keyUpper >> 29) | (temp << 6);
        keyLower = keyLower >> 29;

        // If you want to rotate right use the following code:
        long tempRightRotate = ((keyUpper >>> 35) | (keyLower << 29)) & 0x7FFFFFFF;
        keyLower = (keyLower >> 29) | (tempRightRotate << 6);
        keyUpper = keyUpper >> 29;

        // Print the results to verify
        System.out.println("keyLower: " + Long.toHexString(keyLower));
        System.out.println("keyUpper: " + Long.toHexString(keyUpper));
    }
}