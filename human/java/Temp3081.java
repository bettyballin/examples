public class Temp3081 {
    public static void main(String[] args) {
        byte[] iv = new byte[] { 
            0x01, 0x02, 0x03, 0x04, 
            0x05, 0x06, 0x07, 0x08, 
            0x09, 0x00, 0x01, 0x02, 
            0x03, 0x04, 0x05, 0x06 
        };
        
        // Print the byte array to verify
        for (byte b : iv) {
            System.out.printf("%02x ", b);
        }
    }
}