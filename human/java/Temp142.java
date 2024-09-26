public class Temp142 {
    public static void main(String[] args) {
        String someValue = "<tag>Some XML content</tag>";
        String escapedXml = escapeXml(someValue);
        System.out.println(escapedXml);
    }

    public static String escapeXml(String input) {
        if (input == null) return null;
        StringBuilder escaped = new StringBuilder();
        for (char c : input.toCharArray()) {
            switch (c) {
                case '<': escaped.append("&lt;"); break;
                case '>': escaped.append("&gt;"); break;
                case '&': escaped.append("&amp;"); break;
                case '"': escaped.append("&quot;"); break;
                case '\'': escaped.append("&#39;"); break;
                default: escaped.append(c); break;
            }
        }
        return escaped.toString();
    }
}