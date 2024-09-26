public class Temp1702 {

    public static void main(String[] args) {
        User users = new User("hashedPassword");
        String suppliedPasswordHash = "wrongPasswordHash";

        if(!users.getPassword().equals(suppliedPasswordHash)){
            throw new BadCredentialsException("Invalid credentials");
        }
    }

}

class User {
    private String password;

    public User(String password) {
        this.password = password;
    }

    public String getPassword() {
        return password;
    }
}

class BadCredentialsException extends RuntimeException {
    public BadCredentialsException(String message) {
        super(message);
    }
}