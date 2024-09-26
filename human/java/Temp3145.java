public class Temp3145 {
    public static void main(String[] args) {
        String htmlContent = """
            <html>
                <body>
                    <a href="https://www.google.com/search?client=firefox-b-d&amp;q=xss+encoding+url">
                        Click here.
                    </a>
                </body>
            </html>
        """;

        System.out.println(htmlContent);
    }
}