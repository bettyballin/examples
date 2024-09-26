public class SequenceGenerator {
    public static void main(String[] args) {
        for (int i = 0; i <= 33; i++) {
            System.out.println(i + " : " + sequence(i));
        }
    }

    private static int sequence(int n) {
        if (n % 6 == 0) return 6;
        if (n % 6 == 1) return 1;
        if (n % 6 == 2) return 2;
        if (n % 6 == 3) return 4;
        if (n % 6 == 4) return 8;
        if (n % 6 == 5) return 9;
        return 18; // This line is never reached, but required for compilation
    }
}