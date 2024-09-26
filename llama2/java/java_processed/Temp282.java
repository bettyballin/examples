public class Temp282 {
    public static void main(String[] args) {
        // Sample data to demonstrate the callback functionality
        String data = "Sample data";

        // Define the callback function as a lambda expression
        Callback callback = (d) -> {
            // Process the data and update accordingly
            System.out.println("Processed data: " + d);
        };

        // Call the callback function with the sample data
        callback.call(data);
    }

    // Define a functional interface for the callback
    @FunctionalInterface
    interface Callback {
        void call(String data);
    }
}