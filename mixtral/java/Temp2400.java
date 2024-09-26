import com.vaadin.flow.server.VaadinSession;

public class Temp2400 {
    public static void main(String[] args) {

        // Simulating VaadinSession for the purpose of this example
        VaadinSession session = VaadinSession.getCurrent();
        if (session == null) {
            session = new VaadinSession(null);
            VaadinSession.setCurrent(session);
        }

        // Simulated user attribute
        session.setAttribute("user", "exampleUser");

        String currentUser = (String) VaadinSession.getCurrent().getAttribute("user");
        if (currentUser != null) {
            System.out.println("Current user: " + currentUser);
        } else {
            System.out.println("No user is logged in");
        }
    }
}