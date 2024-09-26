import org.springframework.ui.Model;

public class MyController3 {

    // Other methods and fields

    public String addAttributeToModel(Model model) {
        model.addAttribute("userRole", getUserRole());
        return "viewName"; // Replace with the actual view name
    }

    private String getUserRole() {
        // Implementation of getUserRole
        // This should return a String or any object that represents the user's role
        return "ROLE_USER"; // Example role, replace with actual role retrieval logic
    }
}