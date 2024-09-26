import javax.servlet.*;
import javax.servlet.http.*;
import java.io.*;

public class FileReaderServlet extends HttpServlet {
    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String filePath = "/secret";
        File file = new File(filePath);
        try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
            String line;
            while ((line = reader.readLine()) != null) {
                response.getWriter().println(line);
            }
        }
    }
}