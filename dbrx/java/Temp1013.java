public class Temp1013 {
    public static void main(String[] args) {
        System.out.println("This is just a placeholder main method.");
    }

    // Placeholder enums and methods to make the code syntactically correct
    enum ROLE {
        ADMIN;
        public String getName() {
            return this.name();
        }
    }

    static class AntMatchersStub {
        public AntMatchersStub hasAnyAuthority(String... roles) {
            for (String role : roles) {
                System.out.println("Role: " + role);
            }
            return this;
        }
    }

    // Simulating the antMatchers method
    public static AntMatchersStub antMatchers(String... patterns) {
        for (String pattern : patterns) {
            System.out.println("Pattern: " + pattern);
        }
        return new AntMatchersStub();
    }

    // Simulating the original code behavior
    static {
        Temp1013.antMatchers("/user", "/user.html").hasAnyAuthority(ROLE.ADMIN.getName());
    }
}