import javax.annotation.security.RunAs;
import javax.servlet.annotation.WebServlet;
import javax.servlet.annotation.HttpMethodConstraint;
import javax.servlet.annotation.ServletSecurity;
import javax.servlet.http.HttpServlet;

@RunAs("Employee")
@WebServlet("/myServlet")
@ServletSecurity(
  httpMethodConstraints = @HttpMethodConstraint(value = "GET", rolesAllowed = {"Manager", "Employee"})
)
public class MyServlet extends HttpServlet {
  // ...
}