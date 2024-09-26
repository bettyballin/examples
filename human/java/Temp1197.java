public class Temp1197 {
    public static void main(String[] args) {
        // Escapes and unescapes Strings for Java, Java Script, HTML and XML.
        String javaString = escapeJava("This is a Java string with a newline\nand a tab\tcharacter.");
        String javaScriptString = escapeJavaScript("This is a JavaScript string with a newline\nand a tab\tcharacter.");
        String htmlString = escapeHtml("This is an HTML string with a newline\nand a tab\tcharacter.");
        String xmlString = escapeXml("This is an XML string with a newline\nand a tab\tcharacter.");
        
        System.out.println("Escaped Java String: " + javaString);
        System.out.println("Escaped JavaScript String: " + javaScriptString);
        System.out.println("Escaped HTML String: " + htmlString);
        System.out.println("Escaped XML String: " + xmlString);
    }

    public static String escapeJava(String input) {
        return input.replace("\\", "\\\\").replace("\n", "\\n").replace("\t", "\\t").replace("\"", "\\\"");
    }

    public static String escapeJavaScript(String input) {
        return input.replace("\\", "\\\\").replace("\n", "\\n").replace("\t", "\\t").replace("\"", "\\\"");
    }

    public static String escapeHtml(String input) {
        return input.replace("&", "&amp;").replace("<", "&lt;").replace(">", "&gt;").replace("\"", "&quot;").replace("'", "&#39;");
    }

    public static String escapeXml(String input) {
        return input.replace("&", "&amp;").replace("<", "&lt;").replace(">", "&gt;").replace("\"", "&quot;").replace("'", "&apos;");
    }
}