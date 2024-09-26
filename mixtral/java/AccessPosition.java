import org.springframework.security.core.Authentication;

public final class AccessPosition {
    public boolean toMeOpen(Long invoiceId, Authentication authentication) {
        // Your custom logic here

        return true;  // or false based on your conditions
    }

    public static void main(String[] args) {
        // Example usage
        AccessPosition accessPosition = new AccessPosition();
        Authentication authentication = null; // Replace with actual authentication object
        Long invoiceId = 12345L;

        boolean result = accessPosition.toMeOpen(invoiceId, authentication);
        System.out.println("Access allowed: " + result);
    }
}