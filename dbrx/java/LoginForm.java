public class LoginForm {
    private String username;
    private String password;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public static void main(String[] args) {
        LoginForm login = new LoginForm();
        login.setUsername("admin");
        login.setPassword("1234");
        System.out.println("Username: " + login.getUsername());
        System.out.println("Password: " + login.getPassword());
    }
}