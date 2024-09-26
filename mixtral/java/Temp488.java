public class Temp488 {
    public static void main(String[] args) {
        long A = 5;
        long B = 10;
        long N = 3;

        long result = modMultiply(A, B, N);
        System.out.println("Result: " + result);
        
        long d = 10;
        long x = 2;
        long c = 1;
        long n = 3;
        boolean dj;

        while (d > 0) {
            dj = d % 2 == 1;
            x = modMultiply(x, x, n);

            if (dj)
                c = modMultiply(c, x, n);

            d /= 2;
        }

        System.out.println("Final c: " + c);
    }

    public static long modMultiply(long A, long B, long N) {
        return ((A % N) * (B % N)) % N;
    }
}