public class Temp438 {

    public static void main(String[] args) {
        long lower = 0x123456789ABCDEFL;
        long upper = 0xFEDCBA9876543210L;
        System.out.println("rotateRight: " + rotateRight(lower, upper));
        System.out.println("rotateLeft: " + rotateLeft(lower, upper));
    }

    public static long rotateRight(long lower, long upper) {
        return (lower >>> 29 | (upper << 35));
    }

    public static long rotateLeft(long lower, long upper) {
        return (((upper & 0xFFFFFFFFL) << 3) | (lower >>> 61));
    }
}