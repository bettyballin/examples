public class Temp831 {
    public static void main(String[] args) {
        int a = 2;
        int x = 3;
        int b = 3;
        int y = 2;
        int z = 5;

        long axModZ = modExp(a, x, z);
        long byModZ = modExp(b, y, z);
        long result = (axModZ * byModZ) % z;

        System.out.println("Result: " + result);
    }

    private static long modExp(int base, int exp, int mod) {
        long result = 1;
        long baseMod = base % mod;
        while (exp > 0) {
            if ((exp % 2) == 1) {
                result = (result * baseMod) % mod;
            }
            baseMod = (baseMod * baseMod) % mod;
            exp /= 2;
        }
        return result;
    }
}