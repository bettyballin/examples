public class Temp1457 {
    public static void main(String[] args) {
        String webResourceCollection = """
            <web-resource-collection>
                <web-resource-name>SecretProtection</web-resource-name>
                <url-pattern>/servlet/SalaryServer</url-pattern>
                <url-pattern>/servlet/secret</url-pattern>
                <url-pattern>/test</url-pattern>
            </web-resource-collection>
        """;

        System.out.println(webResourceCollection);
    }
}