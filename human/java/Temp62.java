public class Temp62 {
    public static void main(String[] args) {
        String beanUserControlledValue = "exampleValue";
        String paramFoo = "inputValue";

        System.out.println("<p>" + escapeXml(beanUserControlledValue) + "</p>");
        System.out.println("<p><input name=\"foo\" value=\"" + escapeXml(paramFoo) + "\"></p>");
    }

    private static String escapeXml(String input) {
        if (input == null) {
            return null;
        }
        return input.replace("&", "&amp;")
                    .replace("<", "&lt;")
                    .replace(">", "&gt;")
                    .replace("\"", "&quot;")
                    .replace("'", "&#39;");
    }
}