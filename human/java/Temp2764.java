public class Temp2764 {
    public static void main(String[] args) {
        Temp2764 temp = new Temp2764();
        String hexString = "48656c6c6f20576f726c64"; // Example hex string for "Hello World"
        String result = temp.hexStringtoByteArray(hexString);
        System.out.println(result);
    }

    public String hexStringtoByteArray(String str) {
        byte[] bytes = new byte[str.length() / 2];
        for (int i = 0; i < bytes.length; i++) {
            bytes[i] = (byte) Integer.parseInt(str.substring(2 * i, 2 * i + 2), 16);
        }
        try {
            return new String(bytes, "UTF-8");
        } catch (java.io.UnsupportedEncodingException e) {
            e.printStackTrace();
            return null;
        }
    }
}