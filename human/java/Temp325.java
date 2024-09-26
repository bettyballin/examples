import org.springframework.web.servlet.ModelAndView;

public class Temp325 {
    public static void main(String[] args) {
        // Example usage
        User activeUser = new User("John Doe"); // Assuming User has a constructor that takes a name
        Temp325 handler = new Temp325();
        ModelAndView modelAndView = handler.someRequestHandler(activeUser);
        System.out.println(modelAndView); // You can replace this with actual logic
    }

    public ModelAndView someRequestHandler(User activeUser) {
        // Implement your logic here
        ModelAndView modelAndView = new ModelAndView("viewName"); // Replace "viewName" with your actual view name
        modelAndView.addObject("user", activeUser);
        return modelAndView;
    }
}

class User {
    private String name;

    public User(String name) {
        this.name = name;
    }

    // Getter and Setter methods
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "User{name='" + name + '\'' + '}';
    }
}