public class Temp3252 {
    private static final String[] PUBLIC_MATCHERS = {
            "/css/**",
            "/js/**",
            "/images/**",
    };

    public static void main(String[] args) {
        // Normally, the following code would be part of a Spring Security configuration class
        // This is just to illustrate how you might set up the matchers and authorization rules
        // In a real application, you would not have this in the main method

        // Create a mock HttpSecurity object for demonstration purposes
        HttpSecurity http = new HttpSecurity();

        // Configure the HttpSecurity object
        try {
            http
                .authorizeRequests()
                .antMatchers(PUBLIC_MATCHERS)
                .permitAll()
                .anyRequest()
                .authenticated();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // Mock HttpSecurity class for demonstration purposes
    static class HttpSecurity {
        public AuthorizeRequests authorizeRequests() {
            return new AuthorizeRequests();
        }
    }

    // Mock AuthorizeRequests class for demonstration purposes
    static class AuthorizeRequests {
        public AuthorizeRequests antMatchers(String... matchers) {
            System.out.println("Permitting access to: ");
            for (String matcher : matchers) {
                System.out.println(matcher);
            }
            return this;
        }

        public AuthorizeRequests permitAll() {
            System.out.println("Permit all");
            return this;
        }

        public AuthorizeRequests anyRequest() {
            System.out.println("Any other request must be authenticated");
            return this;
        }

        public AuthorizeRequests authenticated() {
            System.out.println("Authenticated");
            return this;
        }
    }
}