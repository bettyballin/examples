import javax.crypto.SecretKey;

public class Main {
    public static void main(String[] args) {
        SecretKey emptyKey = new EmptyKey();
        System.out.println("Algorithm: " + emptyKey.getAlgorithm());
        System.out.println("Format: " + emptyKey.getFormat());
        System.out.println("Encoded: " + new String(emptyKey.getEncoded()));
    }

    public static class EmptyKey implements SecretKey {
        private static final long serialVersionUID = 1L;

        @Override
        public String getAlgorithm() {
            return "HMAC";
        }

        @Override
        public String getFormat() {
            return "RAW";
        }

        @Override
        public byte[] getEncoded() {
            // return empty key data
            return new byte[0];
        }
    }
}