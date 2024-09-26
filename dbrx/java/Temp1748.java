public class Temp1748 {
    public static void main(String[] args) {
        try {
            // Some code that might throw CryptoException
        } catch (CryptoException e) {
            short reason = e.getReason();
            if (reason == CryptoException.ILLEGAL_USE) {
                // send certain apdu
                System.out.println("Illegal use detected.");
            }
        }
    }
}

// Assuming the CryptoException class is defined somewhere
class CryptoException extends Exception {
    public static final short ILLEGAL_USE = 1;
    private short reason;

    public CryptoException(short reason) {
        this.reason = reason;
    }

    public short getReason() {
        return reason;
    }
}