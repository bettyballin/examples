public class Temp3719 {
    public static void main(String[] args) {
        try {
            // Simulating a condition that throws CryptoException
            throw new CryptoException(CryptoException.ILLEGAL_USE);
        } catch (CryptoException e) {
            if (e.getReason() == CryptoException.ILLEGAL_USE) {
                System.out.println("Sending certain APDU");
            }
        }
    }
}

class CryptoException extends Exception {
    public static final int ILLEGAL_USE = 1;
    private int reason;

    public CryptoException(int reason) {
        this.reason = reason;
    }

    public int getReason() {
        return reason;
    }
}