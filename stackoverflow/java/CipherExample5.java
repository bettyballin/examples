import javax.crypto.Cipher;

public class CipherExample5 {
    public static void main(String[] args) {
        try {
            Cipher cipher = Cipher.getInstance("AES/CBC/PKCS5Padding");
            byte[] PLAINTEXT = "YourPlainText".getBytes();
            byte[] opbytes = new byte[cipher.getOutputSize(PLAINTEXT.length)];
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}