import java.util.Arrays;
import java.util.List;

public class Temp2324 {
    public static void main(String[] args) {
        List<String> patterns = Arrays.asList(
            "/",
            "/index",
            "/static/**",
            "/assets/**",
            "/register",
            "/skillRequest/**",
            "/skillRequest/skillFormUpdate/**",
            "/password/reset",
            "/password/reset/complete",
            "/email/verify",
            "/view/**",
            "/embed/**"
        );

        System.out.println("Permitted URL patterns:");
        for (String pattern : patterns) {
            System.out.println(pattern);
        }
    }
}