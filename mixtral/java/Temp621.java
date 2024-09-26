public class Temp621 {
    public static void main(String[] args) {
        Temp621 temp = new Temp621();
        String result = temp.handleRequest();
        System.out.println(result);
    }

    public String handleRequest() {
        LoginCommand command = new LoginCommand();
        // Simulate adding attribute to model
        System.out.println("Model attribute added: " + command);
        return "login";
    }
}

class LoginCommand {
    // Add properties and methods as needed
}