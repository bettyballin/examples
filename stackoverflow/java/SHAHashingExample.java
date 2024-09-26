import java.security.MessageDigest;

public class SHAHashingExample {
    public static void main(String[] args) {
        try {
            String password = "seed";

            MessageDigest md = MessageDigest.getInstance("SHA-256");
            md.update(password.getBytes());

            byte[] byteData = md.digest();

            //convert the byte to hex format
            StringBuilder sb = new StringBuilder();
            for (byte aByteData : byteData) {
                sb.append(String.format("%02x", aByteData));
            }

            System.out.println("Hex format : " + sb.toString());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}