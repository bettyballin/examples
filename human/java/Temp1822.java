import javax.xml.bind.DatatypeConverter;

public class Temp1822 {
    public static void main(String[] args) {
        String hex = "e6b426aca323815fd6583cbcc4293c8d";
        String message = "Hello world";

        // Encrypt message to HEX
        String encryptedHex = encryptToHex(message);
        System.out.println("Encrypted hex: " + encryptedHex);

        // Decrypt HEX to message
        String decryptedMessage = decryptFromHex(hex);
        System.out.println("Decrypted message: " + decryptedMessage);
    }

    public static String encryptToHex(String message) {
        byte[] bytes = message.getBytes();
        return DatatypeConverter.printHexBinary(bytes);
    }

    public static String decryptFromHex(String hex) {
        byte[] bytes = DatatypeConverter.parseHexBinary(hex);
        return new String(bytes);
    }
}