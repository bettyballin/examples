public class Temp3155 {
    public static void main(String[] args) {
        // Example of method chaining with mock authentication matchers
        matchers("/admin/**").hasAnyRole("ADMIN_STAFF", "ADMIN_MANAGER");
        matchers("/admin/employee").hasRole("ADMIN_MANAGER");
    }

    // Mock method to simulate antMatchers
    public static Temp3155 matchers(String pattern) {
        System.out.println("Matching pattern: " + pattern);
        return new Temp3155();
    }

    // Mock method to simulate hasAnyRole
    public Temp3155 hasAnyRole(String... roles) {
        System.out.println("Has any role: " + String.join(", ", roles));
        return this;
    }

    // Mock method to simulate hasRole
    public Temp3155 hasRole(String role) {
        System.out.println("Has role: " + role);
        return this;
    }
}