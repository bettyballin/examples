import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

public class Temp3289 {
    public static void main(String[] args) {
        // This is just a placeholder as the original code is part of Spring Security configuration
        // Spring Security configurations are usually done in a configuration class extending WebSecurityConfigurerAdapter
        configureLogout();
    }

    public static void configureLogout() {
        System.out.println("Logout configuration:");
        System.out.println("Logout URL: /logout");
        System.out.println("Logout success URL: /logout.done");
        System.out.println("Delete cookies: JSESSIONID");
        System.out.println("Invalidate HTTP session: true");
        
        // Actual Spring Security configuration code would look something like this:
        // http.logout()
        //     .logoutRequestMatcher(new AntPathRequestMatcher("/logout"))
        //     .logoutSuccessUrl("/logout.done")
        //     .deleteCookies("JSESSIONID")
        //     .invalidateHttpSession(true);
    }
}