import java.util.Base64;

public class Temp3367 {
    public static void main(String[] args) {
        byte[] bytesArray = "example".getBytes();
        String hashString = Base64.getEncoder().encodeToString(bytesArray);
        System.out.println(hashString);
    }
}