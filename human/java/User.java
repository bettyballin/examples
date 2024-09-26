public class User {
    private String role;

    public User(String role) {
        this.role = role;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public static void main(String[] args) {
        User user = new User("Admin");
        System.out.println("Role: " + user.getRole());
        user.setRole("User");
        System.out.println("Updated Role: " + user.getRole());
    }
}