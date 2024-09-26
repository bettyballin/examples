public class Temp3123 {
    public static void main(String[] args) {
        boolean hasError = true;  // Simulating the presence of an error
        String errorMessage = "Invalid username or password"; // Simulated error message

        if (hasError) {
            System.out.println("\u001B[31mYour login attempt was not successful, try again.");
            System.out.println("Reason: " + errorMessage + ".\u001B[0m");
        }
    }
}