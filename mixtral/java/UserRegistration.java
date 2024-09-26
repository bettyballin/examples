public class UserRegistration {
    private String username;
    private String password;
    // new property
    private Boolean enabled = false;

    public UserRegistration(String username, String password) {
        this.username = username;
        this.password = password;
    }

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

    public Boolean getEnabled() {
        return enabled;
    }

    public void setEnabled(Boolean enabled) {
        this.enabled = enabled;
    }

    @Override
    public String toString() {
        return "UserRegistration{" +
                "username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", enabled=" + enabled +
                '}';
    }

    public static void main(String[] args) {
        UserRegistration user = new UserRegistration("user1", "pass123");
        user.setEnabled(true);
        System.out.println(user);
    }
}