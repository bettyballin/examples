import java.util.Base64;

public class Temp1477 {
    public static void main(String[] args) {
        String base64Password = "cGFzc3dvcmQ="; // Example base64 encoded password
        byte[] decodedPassword = Base64.getDecoder().decode(base64Password);
        System.out.println(new String(decodedPassword)); // Print the decoded password
    }
}