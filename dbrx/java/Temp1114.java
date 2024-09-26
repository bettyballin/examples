public class Temp1114 {
    public static void main(String[] args) {
        int base = 2;
        int result = 8;
        int modulus = 10;
        int power = findPower(base, result, modulus);
        System.out.println("Power: " + power);
    }

    public static int findPower(int base, int result, int modulus) {
        if (result == 1 || result % modulus != 0) {
            return -1;
        }

        for (int i = 2; i < modulus; ++i) {
            if ((int)Math.pow(base, i) % modulus == result) {
                return i;
            }
        }

        return -1;
    }
}