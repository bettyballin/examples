import javax.xml.bind.DatatypeConverter;

public class Temp327 {
    public static void main(String[] args) {
        // Example byte array for encryptedData
        byte[] encryptedData = "example data".getBytes();

        // Convert byte array to Base64
        String encryptedBase64 = DatatypeConverter.printBase64Binary(encryptedData);

        // Print the Base64 encoded string
        System.out.println(encryptedBase64);
    }
}