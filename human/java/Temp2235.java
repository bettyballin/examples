import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configurers.CsrfConfigurer;
import org.springframework.security.web.SecurityConfigurerAdapter;

public class Temp2235 {
    public static void main(String[] args) {
        Customizer<CsrfConfigurer<HttpSecurity>> customizer = new Customizer<CsrfConfigurer<HttpSecurity>>() {
            @Override
            public void customize(CsrfConfigurer<HttpSecurity> csrfConfigurer) {
                // Customize the CsrfConfigurer here
            }
        };

        // Example usage of the customizer (this is just for illustration and does not actually configure anything)
        HttpSecurity httpSecurity = new HttpSecurity();
        customizer.customize(httpSecurity.csrf());
    }

    // Dummy classes to make the code compile
    static class HttpSecurity {
        public CsrfConfigurer<HttpSecurity> csrf() {
            return new CsrfConfigurer<>(this);
        }
    }

    static class CsrfConfigurer<T> {
        public CsrfConfigurer(T httpSecurity) {
        }
    }

    interface Customizer<T> {
        void customize(T t);
    }
}