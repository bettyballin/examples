import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import javax.servlet.http.HttpSession;
import java.util.Map;

public class Temp1657 {

    static class Teacher {
        private String password;

        public String getPassword() {
            return password;
        }

        public void setPassword(String password) {
            this.password = password;
        }
    }

    public static void main(String[] args) {
        // Example usage
        Temp1657 temp1657 = new Temp1657();
        HttpSession session = new MockHttpSession();
        Teacher teacher = new Teacher();
        teacher.setPassword("$2a$12$eBfGm6fJxWk1eZkQ5nqv.eO/Qp4YvB1x4FZfX6zV7V8QfKbU5sQx2"); // example hashed password
        Map<String, String> user = Map.of("password", "examplePassword");
        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
        
        ResponseEntity<Map<String, String>> response = temp1657.authenticate(session, teacher, user, encoder);
        System.out.println(response);
    }

    public ResponseEntity<Map<String, String>> authenticate(HttpSession session, Teacher t, Map<String, String> user, BCryptPasswordEncoder encoder) {
        if (t != null && encoder.matches(user.get("password"), t.getPassword())) {
            session.setAttribute("teacher", t);
            return ResponseEntity.status(HttpStatus.OK)
                    .body(Map.of("result", "ok", "details", "login approved"));
        }
        return ResponseEntity.status(HttpStatus.UNAUTHORIZED)
                .body(Map.of("result", "error", "details", "login denied"));
    }
}

// Mock HttpSession for demonstration purposes
class MockHttpSession implements HttpSession {
    @Override
    public long getCreationTime() {
        return 0;
    }

    @Override
    public String getId() {
        return null;
    }

    @Override
    public long getLastAccessedTime() {
        return 0;
    }

    @Override
    public ServletContext getServletContext() {
        return null;
    }

    @Override
    public void setMaxInactiveInterval(int interval) {

    }

    @Override
    public int getMaxInactiveInterval() {
        return 0;
    }

    @Override
    public HttpSessionContext getSessionContext() {
        return null;
    }

    @Override
    public Object getAttribute(String name) {
        return null;
    }

    @Override
    public Object getValue(String name) {
        return null;
    }

    @Override
    public Enumeration<String> getAttributeNames() {
        return null;
    }

    @Override
    public String[] getValueNames() {
        return new String[0];
    }

    @Override
    public void setAttribute(String name, Object value) {
        System.out.println("Session attribute set: " + name + " = " + value);
    }

    @Override
    public void putValue(String name, Object value) {

    }

    @Override
    public void removeAttribute(String name) {

    }

    @Override
    public void removeValue(String name) {

    }

    @Override
    public void invalidate() {

    }

    @Override
    public boolean isNew() {
        return false;
    }
}