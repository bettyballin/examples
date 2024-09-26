import javax.annotation.security.RunAs;
import javax.annotation.security.DeclareRoles;
import javax.servlet.annotation.WebServlet;
import javax.servlet.annotation.ServletSecurity;
import javax.servlet.annotation.HttpMethodConstraint;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@RunAs("Employee")
@WebServlet("/myServlet")
@ServletSecurity(
  httpMethodConstraints = {
    @HttpMethodConstraint(value = "GET", rolesAllowed = "Manager"),
    @HttpMethodConstraint(value = "POST", rolesAllowed = "Employee")
  }
)
@DeclareRoles({"Manager", "Employee"})
public class MyServlet extends HttpServlet {

  @Override
  protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
    response.getWriter().write("GET request received.");
  }

  @Override
  protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
    response.getWriter().write("POST request received.");
  }
}