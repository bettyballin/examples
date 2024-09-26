import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import feign.auth.BasicAuthRequestInterceptor;

@SpringBootApplication
public class Temp3079 {

    @Autowired
    private LoginProperties loginProperties; 

    public static void main(String[] args) {
        SpringApplication.run(Temp3079.class, args);
    }

    @Bean
    public BasicAuthRequestInterceptor basicAuthRequestInterceptor() {
        return new BasicAuthRequestInterceptor(loginProperties.getUserName(), loginProperties.getPassword());
    }
}

class LoginProperties {
    private String userName;
    private String password;

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}