import org.apache.commons.text.StringEscapeUtils;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class Temp509 {
    public static void main(String[] args) {
        // This is a placeholder main method to demonstrate the usage
        // In a real-world scenario, the below methods would be called within a servlet
    }

    public void processRequest(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String userInput = request.getParameter("product_name");
        String encodedInput = org.apache.commons.text.StringEscapeUtils.escapeHtml4(userInput);

        // Save the encoded input to your database
        // ... (database saving logic here)

        // When displaying data use:
        response.getWriter().write(encodedInput);
    }
}