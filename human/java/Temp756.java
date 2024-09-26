public class Temp756 {
    public static void main(String[] args) {
        // Sample initialization of variables
        int a = 1; // Example value
        int b = 1; // Example value
        char currentChar = 'B'; // Example value

        char finalChar = (char)((a * (currentChar - 'A') + b) % 26 + 'A');
        System.out.println(finalChar);
    }
}