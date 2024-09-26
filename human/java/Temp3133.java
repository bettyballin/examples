public class Temp3133 {
    public static void main(String[] args) {
        System.out.println(getFormHtml());
    }

    private static String getFormHtml() {
        return "<form action=\"/login\" method=\"post\">\n" +
               "    <input type=\"text\" name=\"username\" />\n" +
               "    <input type=\"password\" name=\"password\" />\n" +
               "    <button type=\"submit\">Login</button>\n" +
               "</form>";
    }
}