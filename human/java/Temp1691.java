public class Temp1691 {
    public static void main(String[] args) {
        String formula = "(java.lang.Runtime.getRuntime().exec('some-malicious-script'), a+b)";
        System.out.println(formula);
    }
}