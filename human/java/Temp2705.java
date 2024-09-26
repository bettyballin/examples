import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

public class Temp2705 {
    public static void main(String[] args) {
        AntPathRequestMatcher matcher = new AntPathRequestMatcher("/**");
        System.out.println("Matcher pattern: " + matcher.getPattern());
    }
}