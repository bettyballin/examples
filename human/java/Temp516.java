import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.PageContext;
import javax.servlet.jsp.tagext.SimpleTagSupport;
import java.io.IOException;

public class Temp516 {
    public static void main(String[] args) {
        // This method is not used in web applications to render HTML, so no implementation is needed
    }
}

class CustomTag extends SimpleTagSupport {
    public void doTag() throws IOException {
        PageContext pageContext = (PageContext) getJspContext();
        JspWriter out = pageContext.getOut();
        HttpServletRequest request = (HttpServletRequest) pageContext.getRequest();
        HttpServletResponse response = (HttpServletResponse) pageContext.getResponse();

        String user = (String) request.getSession().getAttribute("SPRING_SECURITY_LAST_USERNAME");
        String logoutUrl = request.getContextPath() + "/j_spring_security_logout";

        out.write("<a href=\"" + response.encodeURL(logoutUrl) + "\">Logout " + user + "</a>");
    }
}