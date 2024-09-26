public class RandomNumberGenerator {
    private long seed;

    public RandomNumberGenerator(long seed) {
        this.seed = seed;
    }

    public int nextInt(int x) {
        if (x <= 0)
            throw new IllegalArgumentException("bound must be positive");

        int bits, val;
        do {
            seed ^= (seed << 21);
            seed ^= (seed >>> 35);
            seed ^= (seed << 4);

            bits = (int)(seed & ((1L << 31) - 1));
            val = bits % x;
        } while (bits - val + (x - 1) < 0);
        return val;
    }
}