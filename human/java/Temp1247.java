public class Temp1247 {
    public static void main(String[] args) {
        String html = "<html>" +
                      "<head>" +
                      "<meta name=\"_csrf\" content=\"${_csrf.token}\"/>" +
                      "<meta name=\"_csrf_header\" content=\"${_csrf.headerName}\"/>" +
                      "</head>" +
                      "</html>";
        System.out.println(html);
    }
}