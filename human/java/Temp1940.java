public class Temp1940 {
    public static void main(String[] args) {
        System.out.println(generateHashCode(5, 10));
    }

    public static int generateHashCode(int a, int b) {
        // Start with a non-zero constant. Prime is preferred
        int result = 17;
        // For each field multiply the previous result by a prime and add
        result = 31 * result + a;         
        result = 31 * result + b;         
        return result;
    }
}