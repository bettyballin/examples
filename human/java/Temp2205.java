public class Temp2205 {
    public static void main(String[] args) {
        int dkLen = 32; // Desired length of the derived key
        int hLen = 20; // Length of the hash output (e.g., SHA-1 is 20 bytes)
        int numBlocks = (int) Math.ceil((double) dkLen / hLen);

        byte[] password = "password".getBytes();
        byte[] salt = "salt".getBytes();
        int iterations = 1000;

        byte[] derivedKey = new byte[dkLen];
        int offset = 0;

        for (int i = 1; i <= numBlocks; i++) {
            byte[] block = F(password, salt, iterations, i);
            int length = Math.min(hLen, dkLen - offset);
            System.arraycopy(block, 0, derivedKey, offset, length);
            offset += length;
        }

        // Print derived key
        for (byte b : derivedKey) {
            System.out.printf("%02x", b);
        }
    }

    public static byte[] F(byte[] password, byte[] salt, int iterations, int blockIndex) {
        try {
            javax.crypto.SecretKeyFactory skf = javax.crypto.SecretKeyFactory.getInstance("PBKDF2WithHmacSHA1");
            javax.crypto.spec.PBEKeySpec spec = new javax.crypto.spec.PBEKeySpec(
                    new String(password).toCharArray(),
                    salt,
                    iterations,
                    160 // 160 bits = 20 bytes
            );
            byte[] block = skf.generateSecret(spec).getEncoded();
            return block;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}