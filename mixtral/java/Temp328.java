import javax.xml.bind.DatatypeConverter;

public class Temp328 {
    public static void main(String[] args) {
        String encryptedBase64 = "U29tZSBleGFtcGxlIHRleHQ="; // Example Base64 encoded string
        byte[] encryptedByteArray = DatatypeConverter.parseBase64Binary(encryptedBase64);

        // Print the decoded byte array as a string to verify
        String decodedString = new String(encryptedByteArray);
        System.out.println("Decoded string: " + decodedString);
    }
}