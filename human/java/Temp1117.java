public class Temp1117 {
    public static void main(String[] args) {
        long startTime = System.nanoTime();

        // Your code here
        System.out.println("Hello, World!");

        long endTime = System.nanoTime();
        long duration = (endTime - startTime);

        System.out.println("Execution time in nanoseconds: " + duration);
        System.out.println("Execution time in milliseconds: " + duration / 1000000);
    }
}