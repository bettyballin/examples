public class Temp1196 {
    public static void main(String[] args) {
        byte[] hash = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        System.out.println(bytesToHex(hash));
    }

    public static String bytesToHex(byte[] hash) {
        StringBuffer hexString = new StringBuffer();

        for (int i = 0; i < hash.length; i++) {
            String hex = Integer.toHexString(0xff & hash[i]);
            if (hex.length() == 1) hexString.append('0');
            hexString.append(hex);
        }

        return hexString.toString();
    }
}