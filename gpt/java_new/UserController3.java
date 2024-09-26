import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.ui.Model;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

// Assuming the User class, userService, and PassEncoding are already defined elsewhere
public class UserController3 {
    private static final Logger logger = LoggerFactory.getLogger(UserController3.class);
    
    // The userService should be autowired or otherwise injected here
    private final UserService userService;
    
    // Constructor for dependency injection
    public UserController3(UserService userService) {
        this.userService = userService;
    }
    
    @RequestMapping(value = {"/home/editUser"}, method = RequestMethod.POST)
    public String home(@ModelAttribute("editUser") User editUser, Model model) {
        logger.info("/home/editUser");
        try {
            User user = userService.findById(editUser.getId());
            if (!user.equals(editUser)) {
                // Check if the password from the form matches the encoded password from the database
                if (PassEncoding.getInstance().getPasswordEncoder().matches(editUser.getPassword_1(), user.getPassword())) {
                    // If they match, encode the new password and update the user
                    editUser.setPassword(PassEncoding.getInstance().getPasswordEncoder().encode(editUser.getPassword()));
                    userService.update(editUser);
                    // Assuming you want to add a success message to the model
                    model.addAttribute("message", "User updated successfully!");
                } else {
                    // Assuming you want to add an error message to the model
                    model.addAttribute("error", "Passwords do not match.");
                }
            }
        } catch (Exception e) {
            logger.error("Error updating user", e);
            // Assuming you want to handle the error by adding an error message to the model
            model.addAttribute("error", "Error updating user: " + e.getMessage());
        }
        return "home";
    }
}