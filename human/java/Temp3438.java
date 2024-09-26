public class Temp3438 {
    public static void main(String[] args) {
        // Assuming 'http' is an instance of HttpSecurity, typically found in a Spring Security configuration
        // Since this is not complete without context, we'll define a mock method to simulate the behavior
        HttpSecurity http = new HttpSecurity();
        http.formLogin(form -> form
                .loginPage("/index?showDialog=true")
                .loginProcessingUrl("/index")
        );
    }

    // Mock class to simulate HttpSecurity behavior
    static class HttpSecurity {
        public HttpSecurity formLogin(FormLoginConfigurer configurer) {
            configurer.configure(new FormLogin());
            return this;
        }
    }

    // Mock interface to simulate form login configuration
    interface FormLoginConfigurer {
        void configure(FormLogin formLogin);
    }

    // Mock class to simulate FormLogin behavior
    static class FormLogin {
        public FormLogin loginPage(String loginPage) {
            System.out.println("Login page set to: " + loginPage);
            return this;
        }

        public FormLogin loginProcessingUrl(String loginProcessingUrl) {
            System.out.println("Login processing URL set to: " + loginProcessingUrl);
            return this;
        }
    }
}