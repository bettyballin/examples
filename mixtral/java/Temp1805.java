import java.util.function.Consumer;
import java.util.function.Predicate;

public class Temp1805 {
    public static void main(String[] args) {
        HttpSecurity http = new HttpSecurity();

        http.logout(l -> l.requiresLogout(r -> r.antMatchers("/logout")));
    }
}

class HttpSecurity {
    public LogoutConfigurer logout(Consumer<LogoutConfigurer> logoutConfigurerConsumer) {
        LogoutConfigurer logoutConfigurer = new LogoutConfigurer();
        logoutConfigurerConsumer.accept(logoutConfigurer);
        return logoutConfigurer;
    }
}

class LogoutConfigurer {
    public LogoutConfigurer requiresLogout(Predicate<RequestMatcher> requiresLogoutPredicate) {
        RequestMatcher matcher = new RequestMatcher();
        if (requiresLogoutPredicate.test(matcher)) {
            System.out.println("Logout required for: " + matcher.pattern);
        }
        return this;
    }
}

class RequestMatcher {
    String pattern;

    public RequestMatcher() {
    }

    public RequestMatcher antMatchers(String pattern) {
        this.pattern = pattern;
        return this;
    }
}