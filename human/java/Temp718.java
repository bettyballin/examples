public class Temp718 {
    public static void main(String[] args) {
        byte[] array = {0x1, 0xA, 0xF, 0x10}; // Example byte array
        String hexString = javax.xml.bind.DatatypeConverter.printHexBinary(array);
        System.out.println(hexString);
    }
}