import java.security.Principal;

interface Authentication extends Principal {
    // Define additional methods if needed
}

class CustomUser {
    private String name;

    public CustomUser(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}

class MyCustomAuth implements Authentication {
    private final CustomUser user;

    public MyCustomAuth(CustomUser user) {
        this.user = user;
    }

    @Override
    public String getName() {
        return user.getName();
    }

    // Implement additional methods from Authentication if any
}

public class Main {
    public static void main(String[] args) {
        CustomUser user = new CustomUser("JohnDoe");
        MyCustomAuth auth = new MyCustomAuth(user);
        System.out.println("Authenticated user: " + auth.getName());
    }
}