public class Temp111 {
    public static void main(String[] args) {
        byte[] encryptedText = {0x1a, 0x2b, 0x3c}; // Sample byte array for demonstration
        StringBuilder sb = new StringBuilder();
        for (byte b : encryptedText) {
            sb.append(String.format("%02x", b));
        }
        System.out.println("Encrypted Text      = " + sb);
    }
}