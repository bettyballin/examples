public class Main38 {
    public static void main(String[] args) {
        int a = Integer.parseInt("42", 16);
        int b = Integer.parseInt("45", 16);
        System.out.println(Integer.toString(a ^ b, 16));
    }
}