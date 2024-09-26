import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.springframework.context.annotation.Bean;
import org.springframework.oxm.jaxb.Jaxb2Marshaller;
import org.springframework.ws.client.core.WebServiceTemplate;
import org.springframework.ws.transport.http.HttpComponentsMessageSender;

import javax.net.ssl.SSLContext;
import java.security.KeyManagementException;
import java.security.NoSuchAlgorithmException;

public class Temp442 {

    public static void main(String[] args) {
        try {
            WebServiceTemplate template = webServiceTemplate();
            System.out.println("WebServiceTemplate configured with URI: " + template.getDefaultUri());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Bean
    public static WebServiceTemplate webServiceTemplate() throws Exception {
        WebServiceTemplate template = new WebServiceTemplate();

        // Set the default URI for requests
        template.setDefaultUri("https://example.com/ws");

        // Create a custom message sender
        HttpComponentsMessageSender httpComponentsMessageSender = createHttpComponentsMessageSender();

        // Configure SSL
        configureSsl(httpComponentsMessageSender);

        // Set the message sender
        template.setMessageSender(httpComponentsMessageSender);

        return template;
    }

    public static HttpComponentsMessageSender createHttpComponentsMessageSender() {
        return new HttpComponentsMessageSender(HttpClients.createDefault());
    }

    public static void configureSsl(HttpComponentsMessageSender messageSender)
            throws NoSuchAlgorithmException, KeyManagementException {
        SSLContext sslContext = SSLContext.getInstance("TLS");
        sslContext.init(null, null, null);

        CloseableHttpClient httpClient = HttpClients.custom()
                .setSSLContext(sslContext)
                .build();

        messageSender.setHttpClient(httpClient);
    }
}