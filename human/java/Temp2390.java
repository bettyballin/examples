public class Temp2390 {
    public static void main(String[] args) {
        // Simulated method to demonstrate how the given string could be used.
        // In a real scenario, this would be part of a web framework or security configuration.
        anyRequest()
            .access("@accessService.hasAccess(request.requestURI) && hasRole('USER')");
    }

    // Dummy method to simulate the method call
    public static Temp2390 anyRequest() {
        return new Temp2390();
    }

    // Dummy method to simulate the access check
    public Temp2390 access(String accessRule) {
        System.out.println("Access rule applied: " + accessRule);
        return this;
    }
}