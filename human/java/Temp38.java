public class Temp38 {
    public static void main(String[] args) {
        byte[] digest = {0x12, 0x34, 0x56, 0x78}; // Example byte array
        for (byte b : digest) {
            System.out.format("%02x", b);
        }
        System.out.println();
    }
}