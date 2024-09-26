public class Temp1771 {
    public static void main(String[] args) {
        // Since Java does not support HTML directly, let's print the HTML as a string
        String htmlLink = "<a href=\"${pageContext.request.contextPath}/logout?${_csrf.parameterName}=${_csrf.token}\">Logout</a>";
        System.out.println(htmlLink);
    }
}