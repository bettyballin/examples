public class Temp2728 {
    public static void main(String[] args) {
        // Example usage of listRecipes method
        Model model = new Model();
        User user = new User();
        Temp2728 temp = new Temp2728();
        String result = temp.listRecipes(model, user);
        System.out.println(result);
    }

    public String listRecipes(Model model, @AuthenticationPrincipal User user) {
        // Example implementation
        return "Listing recipes for user: " + user.getUsername();
    }
}

class Model {
    // Dummy class for example
}

class User {
    // Dummy class for example
    public String getUsername() {
        return "dummyUser";
    }
}

// Dummy annotation for example
@interface AuthenticationPrincipal {
}