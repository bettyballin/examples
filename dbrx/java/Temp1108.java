import javax.crypto.spec.SecretKeySpec;

public class Temp1108 {
    public static void main(String[] args) {
        // Replace this with your actual key byte array
        byte[] rawKey = new byte[] {0x00, 0x01, 0x02, 0x03, 0x04, 0x05, 0x06, 0x07, 0x08, 0x09, 0x0A, 0x0B, 0x0C, 0x0D, 0x0E, 0x0F};
        
        try {
            SecretKeySpec spec = new SecretKeySpec(rawKey, "AES");
            System.out.println("SecretKeySpec created: " + spec);
        } catch (Exception e) {
            System.out.println("Error creating SecretKeySpec: " + e);
        }
    }
}