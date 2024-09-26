public class Temp3095 {
    public static void main(String[] args) {
        System.out.println("Ant matchers are being set up...");

        // Simulating antMatchers setup
        antMatchers("/home/**").permitAll();
        antMatchers("/**").permitAll();

        System.out.println("Ant matchers setup complete.");
    }

    // Simulating antMatchers method
    public static Temp3095 antMatchers(String pattern) {
        System.out.println("Setting antMatcher for pattern: " + pattern);
        return new Temp3095();
    }

    // Simulating permitAll method
    public void permitAll() {
        System.out.println("Setting permission to permit all.");
    }
}