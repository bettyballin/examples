import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class YourApp {
    public static void main(String[] args) {
        System.setProperty("http.proxyHost", "your_proxy_host");
        // ...

        SpringApplication.run(YourApp.class, args);
    }
}