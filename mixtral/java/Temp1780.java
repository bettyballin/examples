public class Temp1780 {
    public static void main(String[] args) {
        // Simulating the HttpSecurity object and its methods
        HttpSecurity httpSecurity = new HttpSecurity();

        httpSecurity
            .authorizeRequests()
                // Allow access to the following paths
                .antMatchers("/", "/products/product/show/*", "/console/**").permitAll()
                // Add this line
                .antMatchers("/**/*.css", "/**/*.js").permitAll();
    }
}

class HttpSecurity {
    public AuthorizeRequests authorizeRequests() {
        return new AuthorizeRequests();
    }

    class AuthorizeRequests {
        public AuthorizeRequests antMatchers(String... patterns) {
            // Simulate antMatchers logic
            System.out.println("Patterns: " + String.join(", ", patterns));
            return this;
        }

        public AuthorizeRequests permitAll() {
            // Simulate permitAll logic
            System.out.println("Permit all for the above patterns.");
            return this;
        }
    }
}