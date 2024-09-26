import javax.crypto.Cipher;
import javax.crypto.CipherOutputStream;
import javax.crypto.SecretKey;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;
import java.io.OutputStream;
import java.net.Socket;

public class Temp966 {
    public static void main(String[] args) {
        try {
            byte[] keyBytes = "1234123412341234".getBytes();
            final byte[] ivBytes = new byte[] { 0x00, 0x01, 0x02, 0x03, 0x04, 0x05, 0x06,
                    0x07, 0x08, 0x09, 0x0a, 0x0b, 0x0c, 0x0d, 0x0e, 0x0f }; //example

            final SecretKey key = new SecretKeySpec(keyBytes, "AES");
            final IvParameterSpec IV = new IvParameterSpec(ivBytes);
            final Cipher cipher = Cipher.getInstance("AES/CFB8/NoPadding");
            cipher.init(Cipher.ENCRYPT_MODE, key, IV);

            //assuming your Socket is called "socket"
            Socket socket = new Socket("localhost", 12345); // replace with actual host and port
            CipherOutputStream cstream = new CipherOutputStream(socket.getOutputStream(), cipher);

            //code to write ChatMessage object
            String message = "Hello, this is a test message!";
            cstream.write(message.getBytes());
            cstream.flush();
            cstream.close();
            socket.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}