public class EncryptionUtil2 {

    public static void main(String[] args) {
        try {
            byte[] encryptedData = encryptData("Confidential data");
            String s = bytesToHex(encryptedData);
            byte[] bb = hexStringToByteArray(s);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static byte[] encryptData(String data) {
        // Assuming there's an encryption function here
        return data.getBytes(); // Placeholder
    }

    private static String bytesToHex(byte[] bytes) {
        StringBuilder hexString = new StringBuilder(2 * bytes.length);
        for (byte b : bytes) {
            String hex = Integer.toHexString(0xff & b);
            if (hex.length() == 1) {
                hexString.append('0');
            }
            hexString.append(hex);
        }
        return hexString.toString();
    }

    private static byte[] hexStringToByteArray(String s) {
        int len = s.length();
        byte[] data = new byte[len / 2];
        for (int i = 0; i < len; i += 2) {
            data[i / 2] = (byte) ((Character.digit(s.charAt(i), 16) << 4)
                                 + Character.digit(s.charAt(i+1), 16));
        }
        return data;
    }
}