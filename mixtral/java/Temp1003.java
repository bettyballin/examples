public class Temp1003 {
    public static void main(String[] args) {
        byte b = 10; // Example byte value
        StringBuilder sb = new StringBuilder();
        sb.append(Integer.toBinaryString((b & 0xFF) + 0x100).substring(1));
        System.out.println(sb.toString());
    }
}