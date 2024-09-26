import android.util.Base64;

public class Decoder {
    public static void main(String[] args) {
        byte[] decrypted = {/* Some byte data */};
        String decryptedMessage = Base64.encodeToString(decrypted, Base64.DEFAULT);
        System.out.println(decryptedMessage);
    }
}