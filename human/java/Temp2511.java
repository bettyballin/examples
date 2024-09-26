public class Temp2511 {
    public static void main(String[] args) {
        byte[] curveOIDHeader = new byte[] {
            0x30, 0x59, 0x30, 0x13, 0x06, 0x07, 0x2A, (byte) 0x86,
            0x48, (byte) 0xCE, 0x3D, 0x02, 0x01, 0x06, 0x08, (byte) 0x2A,
            (byte) 0x86, 0x48, (byte) 0xCE, 0x3D, 0x03, 0x01, 0x07, 0x03,
            0x42, 0x00
        };
        int curveOIDHeaderLen = 26;

        byte[] rawPublicKeyBytes = new byte[] { /* Add your raw public key bytes here */ };

        byte[] data = new byte[curveOIDHeaderLen + rawPublicKeyBytes.length];
        System.arraycopy(curveOIDHeader, 0, data, 0, curveOIDHeaderLen);
        System.arraycopy(rawPublicKeyBytes, 0, data, curveOIDHeaderLen, rawPublicKeyBytes.length);

        // Print the result for verification
        for (byte b : data) {
            System.out.printf("%02X ", b);
        }
    }
}