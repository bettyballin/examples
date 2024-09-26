public class Temp3108 {
    public static void main(String[] args) {
        User user1 = new User("exampleUsername", "examplePassword");
        String encodedPwd = "encodedPassword"; // Placeholder for the encoded password
        String[] authorities = {"ROLE_USER"}; // Placeholder for authorities
        User user = new User(user1.getUsername(), encodedPwd, authorities);

        System.out.println("Username: " + user.getUsername());
        System.out.println("Encoded Password: " + user.getPassword());
        System.out.print("Authorities: ");
        for (String auth : user.getAuthorities()) {
            System.out.print(auth + " ");
        }
    }
}

class User {
    private String username;
    private String password;
    private String[] authorities;

    public User(String username, String password) {
        this.username = username;
        this.password = password;
    }

    public User(String username, String password, String[] authorities) {
        this.username = username;
        this.password = password;
        this.authorities = authorities;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public String[] getAuthorities() {
        return authorities;
    }
}