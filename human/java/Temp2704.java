import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

public class Temp2704 {
    public static void main(String[] args) {
        AntPathRequestMatcher matcher = new AntPathRequestMatcher("/path/**");
        System.out.println("Matcher created for pattern: " + matcher.getPattern());
    }
}