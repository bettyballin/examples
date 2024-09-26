public class Temp374 {

    public static void main(String[] args) {
        // Simulate the script execution
        simulateScriptExecution();
    }

    public static void simulateScriptExecution() {
        success("Login successful");
        error(401, "Unauthorized");
    }

    public static void success(String data) {
        // Handle successful login
        System.out.println(data);
    }

    public static void error(int status, String responseText) {
        // Handle error
        if (status == 401 || "Unauthorized".equals(responseText)) {
            System.out.println("Invalid username/password");
        }
    }
}