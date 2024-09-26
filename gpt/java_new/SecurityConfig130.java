public class SecurityConfig130 {
    public static final String API_BASE = "/rest/**"; // This matches all requests starting with /rest

    // ... assuming this is within a method context of a configuration method
    public void configure() {
        // .antMatchers(API_BASE).authenticated() should be within a method call chain for configuration
        // Example usage within a security configuration
        // http.antMatcher(API_BASE).authorizeRequests().anyRequest().authenticated();
    }
}