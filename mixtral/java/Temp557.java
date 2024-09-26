public class Temp557 {
    public static void main(String[] args) {

        String input = "Hello";
        char[] charArray1 = input.toCharArray();

        // Printing charArray1 to verify
        System.out.println("charArray1: ");
        for (char c : charArray1) {
            System.out.print(c + " ");
        }
        System.out.println();

        int length = input.length();
        char[] charArray2 = new char[length];
        for (int i = 0; i < length; ++i) {
            charArray2[i] = input.charAt(i);
        }

        // Printing charArray2 to verify
        System.out.println("charArray2: ");
        for (char c : charArray2) {
            System.out.print(c + " ");
        }
    }
}