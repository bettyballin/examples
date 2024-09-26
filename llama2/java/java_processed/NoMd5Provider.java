import java.security.*;

public class NoMd5Provider extends Provider {
    public NoMd5Provider() {
        super("NoMd5", 1.0, "A custom provider that disables MD5");
        put("MessageDigest.MD5", NoMd5MessageDigest.class.getName());
    }

    public static class NoMd5MessageDigest extends MessageDigest {
        protected NoMd5MessageDigest() {
            super("MD5");
        }

        @Override
        protected void engineUpdate(byte input) {
            throw new UnsupportedOperationException("MD5 is not supported");
        }

        @Override
        protected void engineUpdate(byte[] input, int offset, int len) {
            throw new UnsupportedOperationException("MD5 is not supported");
        }

        @Override
        protected byte[] engineDigest() {
            throw new UnsupportedOperationException("MD5 is not supported");
        }

        @Override
        protected void engineReset() {
            throw new UnsupportedOperationException("MD5 is not supported");
        }

        @Override
        protected int engineGetDigestLength() {
            throw new UnsupportedOperationException("MD5 is not supported");
        }
    }

    public static void main(String[] args) {
        Security.addProvider(new NoMd5Provider());
        try {
            MessageDigest md5 = MessageDigest.getInstance("MD5");
            System.out.println("MD5 MessageDigest instance: " + md5);
        } catch (NoSuchAlgorithmException e) {
            System.out.println("MD5 algorithm is not supported");
        }
    }
}