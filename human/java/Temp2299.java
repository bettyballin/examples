public class Temp2299 {
    public static void main(String[] args) {
        String htmlContent = "<!DOCTYPE html>\n" +
                "<html xmlns=\"http://www.w3.org/1999/xhtml\" " +
                "xmlns:th=\"http://www.thymeleaf.org\" " +
                "xmlns:sec=\"http://www.thymeleaf.org/thymeleaf-extras-springsecurity3\">\n" +
                "    <head>\n" +
                "        <title>Spring Security Example </title>\n" +
                "    </head>\n" +
                "    <body>\n" +
                "    <div th:if=\"${param.error}\">\n" +
                "        Invalid username and password.\n" +
                "    </div>\n" +
                "    <div th:if=\"${param.logout}\">\n" +
                "        You have been logged out.\n" +
                "    </div>\n" +
                "    <form th:action=\"@{/login}\" method=\"post\">\n" +
                "        <div><label> User Name : <input type=\"text\" name=\"username\"/> </label></div>\n" +
                "        <div><label> Password: <input type=\"password\" name=\"password\"/> </label></div>\n" +
                "        <div><input type=\"submit\" value=\"Sign In\"/></div>\n" +
                "    </form>\n" +
                "    </body>\n" +
                "</html>";

        System.out.println(htmlContent);
    }
}