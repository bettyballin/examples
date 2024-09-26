public class Temp1717 {
    public static void main(String[] args) {
        // Simulating the Spring Security DSL for demonstration purposes
        authorizeHttpRequests()
            .requestMatchers("/api/auth/**").permitAll()
            .requestMatchers("/api/test/**").permitAll()
            .requestMatchers(Temp1717.h2ConsolePath + "/**").permitAll();
    }

    // Mock methods to simulate Spring Security behavior
    public static Temp1717 authorizeHttpRequests() {
        return new Temp1717();
    }

    public Temp1717 requestMatchers(String pattern) {
        System.out.println("Configured request matcher for pattern: " + pattern);
        return this;
    }

    public Temp1717 permitAll() {
        System.out.println("All requests are permitted for the configured pattern.");
        return this;
    }

    // Placeholder for h2ConsolePath
    static String h2ConsolePath = "/h2-console";
}