public class Temp3291 {
    public static void main(String[] args) {
        String contextPath = "/yourContextPath"; // replace with your context path
        String csrfParameterName = "csrfTokenName"; // replace with your CSRF parameter name
        String csrfToken = "csrfTokenValue"; // replace with your CSRF token value

        String logoutLink = "<a href=\"" + contextPath + "/logout?" + csrfParameterName + "=" + csrfToken + "\">Logout</a>";
        System.out.println(logoutLink);
    }
}