import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

@Configuration
@ComponentScan(basePackages = "com.example")
public class Temp133 {

    @Autowired
    private CasProxyTicketFactory casProxyTicketFactory;

    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(Temp133.class);
        Temp133 temp = context.getBean(Temp133.class);
        temp.execute();
        context.close();
    }

    public void execute() {
        String ticket = "sample-ticket"; // Assuming 'ticket' is provided or obtained from somewhere
        String serviceUrl = "https://example.com/service";
        String proxyTicket = casProxyTicketFactory.create(ticket, serviceUrl);
        System.out.println("Proxy Ticket: " + proxyTicket);
    }

    @Bean
    public CasProxyTicketFactory casProxyTicketFactory() {
        return new CasProxyTicketFactory();
    }
}

@Component
class CasProxyTicketFactory {

    public String create(String ticket, String serviceUrl) {
        // Simulate the creation of a proxy ticket
        return "proxy-ticket-for-" + serviceUrl;
    }
}