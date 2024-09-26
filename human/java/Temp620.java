public class Temp620 {
    public static void main(String[] args) {
        String urlPattern = "/([a-z]+).xhtml";
        String url = "/example.xhtml";
        
        String group = extractGroup(url, urlPattern);
        if (group != null && hasPermission(group)) {
            System.out.println("Access granted for group: " + group);
        } else {
            System.out.println("Access denied.");
        }
    }

    public static String extractGroup(String url, String pattern) {
        java.util.regex.Pattern p = java.util.regex.Pattern.compile(pattern);
        java.util.regex.Matcher matcher = p.matcher(url);
        if (matcher.find()) {
            return matcher.group(1);
        }
        return null;
    }

    public static boolean hasPermission(String group) {
        // Placeholder for actual permission checking logic
        return "example".equals(group);
    }
}