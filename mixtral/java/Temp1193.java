import java.util.Optional;

public class Temp1193 {
    public static void main(String[] args) {
        // Example usage
        Optional<BaseClientDetails> clientDetails = loadClientByCredentials("clientId", "clientSecret");
        clientDetails.ifPresent(details -> System.out.println("Client details loaded"));
    }

    public static Optional<BaseClientDetails> loadClientByCredentials(String clientId, String clientSecret) {
        final Customer customer = customerService.getCustomerByBothCredentials(clientId, clientSecret);

        if (customer == null) {
            throw new ClientRegistrationException("Invalid credentials");
        }

        // rest of the code to create and return BaseClientDetails object
        BaseClientDetails baseClientDetails = new BaseClientDetails();
        return Optional.of(baseClientDetails);
    }

    // Dummy classes to make the code compile
    static class BaseClientDetails {
        // Add necessary fields and methods
    }

    static class Customer {
        // Add necessary fields and methods
    }

    static class CustomerService {
        public Customer getCustomerByBothCredentials(String clientId, String clientSecret) {
            // Dummy implementation
            return new Customer();
        }
    }

    static class ClientRegistrationException extends RuntimeException {
        public ClientRegistrationException(String message) {
            super(message);
        }
    }

    private static final CustomerService customerService = new CustomerService();
}