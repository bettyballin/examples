// This is a JSP scriptlet which cannot be directly refactored into Java code without the context of a JSP file.
// It should be left as-is within a JSP file. However, if you want to refactor this for use within a Java servlet, it would look something like this:

import javax.servlet.http.HttpServletResponse;

public void noCacheResponse(HttpServletResponse response) {
    response.setHeader("Cache-Control", "no-cache, no-store, must-revalidate"); // HTTP 1.1.
    response.setHeader("Pragma", "no-cache"); // HTTP 1.0.
    response.setDateHeader("Expires", 0); // Proxies.
}