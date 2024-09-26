import org.owasp.esapi.ESAPI;
import org.owasp.esapi.errors.ValidationException;

public class Temp2095 {
    public static void main(String[] args) {
        // Simulating request parameter fetching for demonstration purposes
        String input = "exampleInput"; // Replace with actual request parameter fetching logic

        try {
            // Validate and encode the input
            String validInput = ESAPI.validator().getValidInput(
                "HTTP parameter value", input, "HTTPParameterValue", 2000, true
            );

            // Use canonicalize() to prevent directory traversal attacks
            String safeInput = ESAPI.encoder().canonicalize(validInput).trim();

            // Now use the validated and encoded 'safeInput' in your loop condition
            System.out.println(safeInput);
        } catch (ValidationException e) {
            System.err.println("Invalid input: " + input);
            e.printStackTrace();

            // Handle invalid inputs appropriately
        }
    }
}