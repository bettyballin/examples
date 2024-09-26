public class Temp1007 {
    public static void main(String[] args) {
        byte[] data = {10, 20, 30, 40, 50};
        System.out.println(toHex(data));
    }

    public static String toHex(byte[] data) {
        StringBuilder sb = new StringBuilder(data.length * 2);
        for (int i = 0; i < data.length; i++) {
            sb.append(String.format("%02X", data[i] & 0xFF));
        }
        return sb.toString();
    }
}