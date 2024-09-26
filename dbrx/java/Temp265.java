public class Temp265 {
    public static void main(String[] args) {
        String clean = "Example string with \\r and \\n characters";

        int idxR = clean.indexOf('\\r');
        int idxN = clean.indexOf('\\n');

        System.out.println("Index of \\r: " + idxR);
        System.out.println("Index of \\n: " + idxN);
    }
}