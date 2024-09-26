public class Temp1685 {
    public static void main(String[] args) {
        String htmlForm = "<form method=\"post\" action=\"/do/something\">" +
                "<input type=\"hidden\" name=\"_csrf\" value=\"CSRF_TOKEN\" />" +
                "Name:<br />" +
                "<input type=\"text\" name=\"name\" />" +
                "..." +
                "</form>";

        System.out.println(htmlForm);
    }
}