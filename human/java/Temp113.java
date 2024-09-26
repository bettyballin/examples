public class Main {
    public static void main(String[] args) {
        try {
            System.out.println("Code executed successfully.");
        } catch (SecurityException e) {
            System.err.println("Caught SecurityException: " + e.getMessage());
        }
    }
}