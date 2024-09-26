public class Temp2650 {
    public static void main(String[] args) {
        System.out.println(renderContent(true, false, true));
    }

    public static String renderContent(boolean isAdmin, boolean isUser, boolean isAuthenticated) {
        StringBuilder content = new StringBuilder();

        if (isAdmin) {
            content.append("ADMIN\n");
        }
        if (isUser) {
            content.append("USER\n");
        }
        if (isAuthenticated) {
            content.append("Text visible only to authenticated users.\n");
        }

        return content.toString();
    }
}