class User {
    public boolean isAllowedTo(String permission, int articleId) {
        // Dummy implementation for demonstration purposes
        return "EditArticle".equals(permission) && articleId == 27;
    }
}

class Request {
    private User user;

    public Request(User user) {
        this.user = user;
    }

    public User getUser() {
        return user;
    }
}

public class Temp372 {
    public static void main(String[] args) {
        User user = new User();
        Request request = new Request(user);

        if (request.getUser().isAllowedTo("EditArticle", 27)) {
            System.out.println("User is allowed to edit the article.");
            // Add additional logic here if needed
        } else {
            System.out.println("User is not allowed to edit the article.");
        }
    }
}