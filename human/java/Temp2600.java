public class Temp2600 {
    public static void main(String[] args) {
        byte[] keyData = {0x1, 0x2, 0x3, 0x4}; // Example key data
        byte[] adjustedKeyData = adjustDESParity(keyData);

        for (byte b : adjustedKeyData) {
            System.out.printf("0x%02X ", b);
        }
    }

    public static byte[] adjustDESParity(final byte[] keyData) {
        for (int i = 0; i < keyData.length; i++) {
            // count the bits, and XOR with 1 if even or 0 if already odd 
            keyData[i] ^= (Integer.bitCount(keyData[i]) % 2) ^ 1;
        }
        return keyData;
    }
}