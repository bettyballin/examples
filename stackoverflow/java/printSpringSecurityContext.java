// Assuming this snippet is part of a servlet or a method where `request` is a valid variable of type `HttpServletRequest`

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

public void printSpringSecurityContext(HttpServletRequest request) {
    HttpSession session = request.getSession(true);
    System.out.println(session.getAttribute("SPRING_SECURITY_CONTEXT"));
}