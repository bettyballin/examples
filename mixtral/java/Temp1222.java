public class Temp1222 {
    public static void main(String[] args) {
        int length = 2;  // Define the length variable
        String regexPattern = "(\\d{" + Integer.toString(length) + "})\\1";
        System.out.println(regexPattern);  // Print the regex pattern to verify
    }
}