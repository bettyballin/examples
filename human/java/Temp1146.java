public class Temp1146 {
    public static void main(String[] args) {
        byte[] byteArray = new byte[] {
            0x00, 0x01, 0x02, 0x03, 0x04, 0x05, 0x06, 0x07, 0x08, 0x09, 0x10, 0x11, 0x12, 0x13, 0x14, 0x15
        };
        
        // Just to demonstrate usage, we'll print the array elements
        for (byte b : byteArray) {
            System.out.printf("0x%02X ", b);
        }
    }
}