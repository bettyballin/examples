import java.util.List;
import java.util.ArrayList;

class Matcher {
    private String mapping;
    private String scope;

    public Matcher(String mapping, String scope) {
        this.mapping = mapping;
        this.scope = scope;
    }

    public String getMapping() {
        return mapping;
    }

    public String getScope() {
        return scope;
    }
}

class MatchersService {
    public List<Matcher> getAll() {
        List<Matcher> matchers = new ArrayList<>();
        matchers.add(new Matcher("/api/test", "read"));
        matchers.add(new Matcher("/api/admin", "write"));
        return matchers;
    }
}

class HttpSecurity {
    public AuthorizeRequests authorizeRequests() {
        return new AuthorizeRequests();
    }

    class AuthorizeRequests {
        public AuthorizedRequest antMatchers(String mapping) {
            System.out.println("Matching: " + mapping);
            return new AuthorizedRequest();
        }
    }

    class AuthorizedRequest {
        public void access(String access) {
            System.out.println("Access: " + access);
        }
    }
}

public class Temp1654 {
    static MatchersService matchersService = new MatchersService();

    public static void main(String[] args) {
        try {
            configure(new HttpSecurity());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void configure(HttpSecurity http) throws Exception {
        List<Matcher> matchers = matchersService.getAll();
        for (Matcher m : matchers) {
            http.authorizeRequests()
                .antMatchers(m.getMapping())
                .access("#oauth2.hasScope('" + m.getScope() + "')");
        }
    }
}