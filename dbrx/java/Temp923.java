import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class Temp923 {
    public static void main(String[] args) {
        Temp923 temp = new Temp923();
        String numSeq = "12345678123456781234567812345678";
        String md5Hash = temp.getMD5FromNumberSequence(numSeq);
        System.out.println("MD5 Hash: " + md5Hash);
    }

    private String getMD5FromNumberSequence(String numSeq) {
        int len = numSeq.length();
        if ((len % 8) != 0 || !numSeq.matches("\\d+")) { 
            throw new IllegalArgumentException("Invalid number sequence");
        }

        byte[] md5Bytes = new byte[len / 2];
        for (int i = 0; i < len; i += 8) {
            String hexByteStr = numSeq.substring(i, i + 8); 
            long lValue = Long.parseLong(hexByteStr, 10);
            md5Bytes[i / 8 * 4] = (byte) ((lValue >> 24) & 0xFFL);
            md5Bytes[i / 8 * 4 + 1] = (byte) ((lValue >> 16) & 0xFFL);
            md5Bytes[i / 8 * 4 + 2] = (byte) ((lValue >> 8) & 0xFFL);
            md5Bytes[i / 8 * 4 + 3] = (byte) (lValue & 0xFFL);
        }

        try {
            MessageDigest md = MessageDigest.getInstance("MD5");
            byte[] originalHash = md.digest(md5Bytes); 
            return getString(originalHash); 

        } catch (NoSuchAlgorithmException e) {
            throw new RuntimeException("MD5 algorithm not found", e);
        }
    }

    private String getString(byte[] bytes) {
        StringBuilder sb = new StringBuilder();
        for (byte b : bytes) {
            sb.append(String.format("%02x", b));
        }
        return sb.toString();
    }
}