public class Temp263 {
    public static void main(String[] args) {
        String htmlForm = """
            <body>
              <form action="/j_spring_security_check" method="POST">
                <label for="username">User Name:</label>
                <input id="username" name="j_username" type="text"/>
                <label for="password">Password:</label>
                <input id="password" name="j_password" type="password"/>
                <input type="submit" value="Log In"/>
              </form>
            </body>
        """;

        System.out.println(htmlForm);
    }
}