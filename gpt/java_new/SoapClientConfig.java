import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class SoapClientConfig {

    @Value("${SOAP_SERVICE_USERNAME}")
    private String username;

    @Value("${SOAP_SERVICE_PASSWORD}")
    private String password;

    // Getters if necessary
    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    // Setters if necessary
    public void setUsername(String username) {
        this.username = username;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}