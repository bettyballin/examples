import javax.security.auth.Subject;
import javax.security.auth.callback.CallbackHandler;
import javax.security.auth.login.LoginContext;
import javax.security.auth.login.LoginException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.security.Principal;

@WebServlet("/login")
public class Temp1165 extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        String username = req.getParameter("username");
        String password = req.getParameter("password");

        // Create a callback handler
        CallbackHandler callbackHandler = new MyCallbackHandler(username, password);

        try {
            LoginContext lc = new LoginContext("my-jaas", callbackHandler);

            // Perform the login
            lc.login();

            Subject subject = lc.getSubject();

            // Associate the authenticated principal with current thread
            HttpServletRequest requestWrapper = injectPrincipal(req, username);

            PrintWriter out = resp.getWriter();
            out.println("Welcome");

        } catch (LoginException e) {
            PrintWriter out = resp.getWriter();
            out.println(e.getMessage());
        }
    }

    private HttpServletRequest injectPrincipal(HttpServletRequest request, String username) throws ServletException {

        // Create a wrapper for the original HTTP servlet request
        return new MyHttpRequestWrapper((javax.servlet.http.HttpServletRequest) request) {

            @Override
            public Principal getUserPrincipal() {
                if (username != null && !"".equals(username))
                    return new UsernamePasswordAuthenticationToken(username, "");

                // Return the original principal
                return super.getUserPrincipal();
            }
        };
    }
    
    // Dummy implementations for missing classes
    private class MyCallbackHandler implements CallbackHandler {
        private String username;
        private String password;

        public MyCallbackHandler(String username, String password) {
            this.username = username;
            this.password = password;
        }

        @Override
        public void handle(javax.security.auth.callback.Callback[] callbacks) throws IOException, UnsupportedCallbackException {
            // Implement callback handling
        }
    }

    private class MyHttpRequestWrapper extends javax.servlet.http.HttpServletRequestWrapper {
        public MyHttpRequestWrapper(javax.servlet.http.HttpServletRequest request) {
            super(request);
        }

        @Override
        public Principal getUserPrincipal() {
            return super.getUserPrincipal();
        }
    }
    
    private class UsernamePasswordAuthenticationToken implements Principal {
        private String name;
        private String credentials;

        public UsernamePasswordAuthenticationToken(String name, String credentials) {
            this.name = name;
            this.credentials = credentials;
        }

        @Override
        public String getName() {
            return name;
        }
    }
}