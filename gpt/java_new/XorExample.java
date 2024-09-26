public class XorExample {
    public static void main(String[] args) {
        int hexValue = 0x6F; // The hexadecimal value for 111
        int key = 0x4B; // The key to XOR with (75 in decimal)
        int result = hexValue ^ key; // Perform XOR operation

        System.out.println("The result of XOR operation: " + result);
        System.out.println("The result in hexadecimal: " + Integer.toHexString(result));
    }
}