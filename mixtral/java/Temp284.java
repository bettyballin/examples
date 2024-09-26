import java.util.List;

public class Temp284 {
    public static void main(String[] args) {
        // Example usage of the method
        Temp284 temp = new Temp284();
        List<Local> locals = temp.findLoggedInUsersLocals("someLogin");
        // Do something with the locals
    }

    @Transactional
    public List<Local> findLoggedInUsersLocals(String login) {
        // Dummy implementation for illustration purposes
        return List.of(new Local()); // Replace with actual logic
    }
}

class Local {
    // Define the Local class properties and methods
}


Note: You need to ensure that you have the necessary dependencies and configuration for `@Transactional` to work, typically provided by a framework like Spring.