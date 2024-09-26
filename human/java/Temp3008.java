public class Temp3008 {
    public static void main(String[] args) {
        String monitorStatus = "secured"; // Example value, replace with actual value
        String access = monitorStatus.equals("secured") ? "ROLE" : "IS_AUTHENTICATED_ANONYMOUSLY";
        System.out.println("<intercept-url pattern=\"/monitoring\" access=\"" + access + "\"/>");
    }
}