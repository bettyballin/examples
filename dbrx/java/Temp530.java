public class Temp530 {

    public static void main(String[] args) {
        User user = new User("user@employer.com"); // Example user

        if (user.getEmail().endsWith("@employer.com")) {
            System.out.println(new EmployerUserDetails(user));
        } else {
            System.out.println(new EmployeeUserDetails(user));
        }
    }
}

class User {
    private String email;

    public User(String email) {
        this.email = email;
    }

    public String getEmail() {
        return email;
    }
}

class EmployerUserDetails {
    private User user;

    public EmployerUserDetails(User user) {
        this.user = user;
    }

    @Override
    public String toString() {
        return "EmployerUserDetails{" +
                "user=" + user.getEmail() +
                '}';
    }
}

class EmployeeUserDetails {
    private User user;

    public EmployeeUserDetails(User user) {
        this.user = user;
    }

    @Override
    public String toString() {
        return "EmployeeUserDetails{" +
                "user=" + user.getEmail() +
                '}';
    }
}