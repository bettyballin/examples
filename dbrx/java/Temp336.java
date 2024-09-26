import java.nio.charset.StandardCharsets;
import java.util.Base64;

public class Temp336 {
    public static void main(String[] args) {
        String input = "wattlebird";
        String resultHash = Base64.getEncoder().encodeToString(input.getBytes(StandardCharsets.UTF_8));
        System.out.println(resultHash);
    }
}