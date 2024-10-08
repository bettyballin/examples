import java.io.File;
import java.io.FileInputStream;
import java.io.DataInputStream;
import java.security.KeyFactory;
import java.security.Key;
import java.security.spec.PKCS8EncodedKeySpec;

public class PrivateKeyReader {
    public static Key get(String filename) throws Exception {
        File f = new File(filename);
        FileInputStream fis = new FileInputStream(f);
        DataInputStream dis = new DataInputStream(fis);
        byte[] keyBytes = new byte[(int) f.length()];
        dis.readFully(keyBytes);
        dis.close();

        PKCS8EncodedKeySpec spec = new PKCS8EncodedKeySpec(keyBytes);
        KeyFactory kf = KeyFactory.getInstance("RSA");
        return kf.generatePrivate(spec);
    }

    public static void main(String[] args) {
        try {
            Key privateKey = get("path/to/private_key.der");
            System.out.println("Private Key: " + privateKey);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}