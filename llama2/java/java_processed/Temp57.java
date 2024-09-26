import java.util.Optional;

public class Temp57 {
    public static void main(String[] args) {
        // Simulate request parameter
        Optional<String> parameter = Optional.ofNullable(getParameter("param"));

        String value = parameter.orElseThrow(() -> new IllegalArgumentException("Missing parameter"));
        System.out.println("Parameter value: " + value);
    }

    // Simulate a method to get a request parameter
    private static String getParameter(String paramName) {
        // For demonstration purposes, return null to simulate a missing parameter
        return null; 
    }
}