public class Temp455 {
    public static void main(String[] args) {
        // Define the block size
        final int BLOCK_SIZE = 16;
        
        // Create a byte array
        byte[] byteArray = new byte[BLOCK_SIZE];
        
        // Add an 0x80 byte at the beginning
        byteArray[0] = (byte) 0x80;
        
        // Print the byte array
        for (byte b : byteArray) {
            System.out.printf("%02X ", b);
        }
    }
}