import java.io.FileOutputStream;
import java.io.IOException;

public class Temp2232 {
    public static void main(String[] args) {
        String iv = "initialVector";
        String aesEncryptedHello = "encryptedHello";
        
        try (FileOutputStream fos = new FileOutputStream("filename")) {
            fos.write((iv + aesEncryptedHello).getBytes());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}