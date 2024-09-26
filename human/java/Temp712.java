import javax.xml.bind.DatatypeConverter;

public class Temp712 {
    public static void main(String[] args) {
        String str = "hello world";
        String hexEncoded = DatatypeConverter.printHexBinary(str.getBytes());
        System.out.println(hexEncoded);

        byte[] decodedBytes = DatatypeConverter.parseHexBinary(hexEncoded);
        String decodedStr = new String(decodedBytes);
        System.out.println(decodedStr);
    }
}