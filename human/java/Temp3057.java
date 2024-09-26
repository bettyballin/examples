public class Temp3057 {
    public static void main(String[] args) {
        String inputType = "hidden";
        String paramName = "csrfParameterName";
        String token = "csrfToken";

        String htmlInput = String.format(
            "<input type=\"%s\" name=\"%s\" value=\"%s\"/>",
            inputType, paramName, token
        );

        System.out.println(htmlInput);
    }
}