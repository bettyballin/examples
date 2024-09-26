import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class StripeConfiguration {
    
    @Value("${stripe.STRIPE_SECRET_KEY}")
    private String stripeSecretKey;
    
    // Assume there might be other properties and methods here
}