public class Temp1686 {
    public static void main(String[] args) {
        String formHtml = "<form id=\"logoutForm\" method=\"POST\" action='<c:url value=\"/logout\"/>'>\n" +
                          "    <sec:csrfInput/>\n" +
                          "</form>";
        System.out.println(formHtml);
    }
}