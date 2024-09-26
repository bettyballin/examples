public class Temp2856 {
    public static void main(String[] args) {
        byte[] xBytes = new byte[] {
            (byte)0b01110100, (byte)0b11001001, (byte)0b01001011, (byte)0b01111010, 
            (byte)0b00000110, (byte)0b01011100, (byte)0b10011001, (byte)0b01101111, 
            (byte)0b10101100, (byte)0b10101011, (byte)0b01000101, (byte)0b10110011, 
            (byte)0b10110001, (byte)0b11000111, (byte)0b00111010, (byte)0b11100101, 
            (byte)0b01101011, (byte)0b00011110, (byte)0b01000000, (byte)0b01001011, 
            (byte)0b00000101, (byte)0b10111101, (byte)0b10011111, (byte)0b01000001, 
            (byte)0b11010110, (byte)0b00110000, (byte)0b10101111, (byte)0b10011101, 
            (byte)0b11100001, (byte)0b01110101, (byte)0b10011010, (byte)0b00101001
        };

        byte[] yBytes = new byte[] {
            (byte)0b10000111, (byte)0b11110111, (byte)0b11110011, (byte)0b11011001, 
            (byte)0b01100101, (byte)0b11100110, (byte)0b01100011, (byte)0b11111010, 
            (byte)0b01001101, (byte)0b01000100, (byte)0b01101110, (byte)0b11100011, 
            (byte)0b10011110, (byte)0b10111111, (byte)0b00000001, (byte)0b00111010, 
            (byte)0b01100010, (byte)0b01001010, (byte)0b01110001, (byte)0b10110001, 
            (byte)0b10110010, (byte)0b11100101, (byte)0b10001100, (byte)0b11100100, 
            (byte)0b00001110, (byte)0b10101011, (byte)0b10111001, (byte)0b10110110, 
            (byte)0b01010010, (byte)0b01000010, (byte)0b01110100, (byte)0b00001100, 
            (byte)0b0000
        };

        System.out.println("X byte array length: " + xBytes.length);
        System.out.println("X bit string length: " + (xBytes.length * 8));
        System.out.println("Y byte array length: " + yBytes.length);
        System.out.println("Y bit string length: " + (yBytes.length * 8));
    }
}