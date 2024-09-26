public class Temp374 {
    public static void main(String[] args) {
        // Example usage
        long A = 7;
        long B = 6;
        long N = 10;
        System.out.println(multiplyMod(A, B, N)); // Output: 2
    }

    public static long multiplyMod(long A, long B, long N) {
        A = A % N;
        if (B == 0)
            return 0;
        else if (B % 2 == 1)
            return (multiplyMod(A, B - 1, N) + A) % N;
        else {
            long temp = multiplyMod(A, B / 2, N);
            return (temp + temp) % N;
        }
    }
}