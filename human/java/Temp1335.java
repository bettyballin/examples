import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.jasig.cas.client.validation.Cas20ServiceTicketValidator;
import org.jasig.cas.client.validation.TicketValidator;

@Configuration
public class Temp1335 {
    public static void main(String[] args) {
        Temp1335 temp = new Temp1335();
        TicketValidator validator = temp.ticketValidator();
        System.out.println("Ticket Validator created: " + validator);
    }

    @Bean
    public TicketValidator ticketValidator() {
        return new Cas20ServiceTicketValidator("https://localhost:8443/cas/p3");
    }
}