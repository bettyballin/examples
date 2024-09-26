import java.time.Duration;

public class Temp346 {
    public static void main(String[] args) {
        Http http = new Http();
        http.saml2Login(saml2 -> {
            saml2.maxAuthenticationAge(Duration.ofMinutes(10));
        });
    }
}

class Http {
    public void saml2Login(Saml2LoginConfigurer configurer) {
        configurer.configure(new Saml2Login());
    }
}

@FunctionalInterface
interface Saml2LoginConfigurer {
    void configure(Saml2Login saml2Login);
}

class Saml2Login {
    public void maxAuthenticationAge(Duration duration) {
        System.out.println("Max authentication age set to: " + duration);
    }
}