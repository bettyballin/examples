import java.nio.file.*;
import java.security.*;
import java.security.spec.*;

public class Temp2412 {
    public static void main(String[] args) {
        try {
            Path path = Paths.get("/path/to/yourfile/publickey");
            byte[] arrByte = Files.readAllBytes(path);
            X509EncodedKeySpec publicSpec = new X509EncodedKeySpec(arrByte);
            KeyFactory keyFactory = KeyFactory.getInstance("RSA");
            PublicKey pubKey = keyFactory.generatePublic(publicSpec);
            System.out.println("Public Key: " + pubKey);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}