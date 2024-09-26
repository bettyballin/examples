public class Temp1151 {
    public static void main(String[] args) {
        try {
            // Code that may throw an exception
            throw new Exception("Sample Exception");
        } catch(Exception e) {
            if (e != null) {
                System.err.println("Caught Exception: " + e.getMessage());
            } else {
                // Handle the case when exception object is null
                System.out.println("An unknown error occurred.");
            }
        }
    }
}