public class Temp623 {
    public static void main(String[] args) {
        checkLogin(); // Call the checkLogin method
    }

    // Placeholder for actual credential validation method
    public static boolean validateCredentials() {
        // Implement your credential validation logic here
        return false;
    }

    public static void checkLogin() {
        int failedAttempts = 0;
        int X = 1; // Replace with desired timeout duration in minutes

        if (!validateCredentials()) {
            failedAttempts++;
            if (failedAttempts >= 3) {
                // Simulating disabling a button and re-enabling after timeout
                System.out.println("Submit button disabled");
                try {
                    Thread.sleep(X * 60 * 1000); // X minutes in milliseconds
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt(); // Restore interrupted status
                    e.printStackTrace();
                }
                failedAttempts = 0;
                System.out.println("Submit button enabled");
            }
        }
    }
}