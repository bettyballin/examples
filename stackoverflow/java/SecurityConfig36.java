import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import java.util.List;

public class SecurityConfig36 {

    private MatchersService matchersService;

    public SecurityConfig36(MatchersService matchersService) {
        this.matchersService = matchersService;
    }

    public void configure(HttpSecurity http) throws Exception {
        List<Matcher> matchers = matchersService.getAll();
        http.authorizeRequests(authorizeRequests -> {
            for (Matcher m : matchers) {
                authorizeRequests.antMatchers(m.getMapping())
                    .access("#oauth2.hasScope('" + m.getScope() + "')");
            }
        });
    }

    // Assuming Matcher and MatchersService classes are defined elsewhere
    public static class Matcher {
        public String getMapping() {
            return null; // Dummy implementation
        }

        public String getScope() {
            return null; // Dummy implementation
        }
    }

    public interface MatchersService {
        List<Matcher> getAll();
    }
}