import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.ws.client.core.WebServiceTemplate;
import org.springframework.ws.transport.http.HttpComponentsMessageSender;

@SpringBootApplication
public class Temp349 {
    public static void main(String[] args) {
        SpringApplication.run(Temp349.class, args);
    }

    @Bean
    public WebServiceTemplate webServiceTemplate() {
        CloseableHttpClient httpClient = HttpClients.createDefault();
        HttpComponentsMessageSender messageSender = new HttpComponentsMessageSender(httpClient);
        // Set SSL context if needed e.g to trust self-signed certificates or specific CAs.
        // See https://hc.apache.org/httpcomponents-client-4.5.x/tutorial/html/connmgmt.html#d5e652 for more details.

        WebServiceTemplate webServiceTemplate = new WebServiceTemplate();
        webServiceTemplate.setMessageSender(messageSender);
        return webServiceTemplate;
    }
}