import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.DatatypeConverter;

public class Temp512 {
    public static void main(String[] args) throws NoSuchAlgorithmException, IOException {
        File folderToSign = new File("path/to/folder"); // Specify the path to the folder
        List<String> entries = new ArrayList<>();
        
        for (File f : folderToSign.listFiles()) {
            MessageDigest md = MessageDigest.getInstance("SHA-256");
            byte[] digest = md.digest(new FileInputStream(f).readAllBytes());
            String hashValue = DatatypeConverter.printHexBinary(digest);
            entries.add(f.getName() + "|" + hashValue);
        }
        
        for (String entry : entries) {
            System.out.println(entry);
        }
    }
}