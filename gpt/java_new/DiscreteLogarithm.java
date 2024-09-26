public class DiscreteLogarithm {

    public static void main(String[] args) {
        int a = 2; // base
        int b = 12; // result of a^x mod p
        int p = 23; // modulus

        int x = discreteLogarithm(a, b, p);
        System.out.println("The value of x is: " + x);
    }

    private static int discreteLogarithm(int a, int b, int p) {
        int currentValue = 1;
        for (int x = 0; x < p - 1; x++) {
            if (currentValue == b) {
                return x;
            }
            currentValue = (currentValue * a) % p;
        }
        return -1; // indicates no solution found
    }
}