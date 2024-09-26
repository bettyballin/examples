import java.nio.file.*;
import java.util.*;
import java.security.*;

public class Demo {
    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        String path = sc.nextLine(); // read all the string from keyboard
        
        byte[] content = Files.readAllBytes(Paths.get(path));
        byte[] hash = MD5(content);
        
        String hashString = Base64.getEncoder().encodeToString(hash);
        System.out.println("MD5: " + hashString); 
    }
    
    public static byte[] MD5(byte[] data) throws Exception {
        MessageDigest messageDigest = MessageDigest.getInstance("MD5");
        messageDigest.update(data);
        return messageDigest.digest();
    }    
}