import org.springframework.ui.Model;
import org.springframework.security.core.annotation.AuthenticationPrincipal;

public class RecipeController {

    public String listRecipes(Model model, @AuthenticationPrincipal User user) {
        // Method implementation goes here
        return "recipes"; // Assuming "recipes" is the view name
    }

    // Other methods and class members go here
}