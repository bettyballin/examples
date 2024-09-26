import java.util.Base64;

public class HashConverter {
    public static void main(String[] args) {
        byte[] bytesArray = new byte[]{/* your byte data */};
        String hashString = Base64.getEncoder().encodeToString(bytesArray);
        System.out.println(hashString);
    }
}