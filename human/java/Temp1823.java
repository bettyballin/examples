public class Temp1823 {
    public static void main(String[] args) {
        int number = 16; // Example number
        int distance = 2; // Example distance
        int result = rotateRight(number, distance);
        System.out.println("Result: " + result);
    }

    public static int rotateRight(int i, int distance) {
        return (i >>> distance) | (i << -distance);
    }
}