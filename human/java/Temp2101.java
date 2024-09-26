public class Temp2101 {
    public static void main(String[] args) {
        System.out.println("Modified with our own implementation of UserDetailsService");
        authenticationManager();
    }

    public static void authenticationManager() {
        System.out.println("authentication-manager alias=\"authenticationManager\"");
        System.out.println("xmlns=\"http://www.springframework.org/schema/security\"");
        System.out.println("authentication-provider ref=\"daoAuthenticationProvider\"");
    }
}