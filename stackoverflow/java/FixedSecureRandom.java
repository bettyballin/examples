import java.security.SecureRandom;

public class FixedSecureRandom extends SecureRandom {
    private static final long serialVersionUID = 1L;
    private int nextBytesIndex = 0;
    private byte[] nextBytesValues = null;

    public void setBytes(byte[] values) {
        this.nextBytesValues = values.clone();
        this.nextBytesIndex = 0;
    }

    @Override
    public void nextBytes(byte[] bytes) {
        if (nextBytesValues == null || nextBytesValues.length == 0) {
            super.nextBytes(bytes);
        } else {
            for (int i = 0; i < bytes.length; i++) {
                bytes[i] = nextBytesValues[nextBytesIndex];
                nextBytesIndex = (nextBytesIndex + 1) % nextBytesValues.length;
            }
        }
    }
}