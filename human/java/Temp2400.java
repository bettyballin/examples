public class Temp2400 {
    public static void main(String[] args) {
        User user = User.withUsername("user").password("{noop}user").roles("USER").build();
        System.out.println("User created: " + user.getUsername());
    }
}

class User {
    private String username;
    private String password;
    private String[] roles;

    private User(String username, String password, String[] roles) {
        this.username = username;
        this.password = password;
        this.roles = roles;
    }

    public static UserBuilder withUsername(String username) {
        return new UserBuilder(username);
    }

    public String getUsername() {
        return username;
    }

    public static class UserBuilder {
        private String username;
        private String password;
        private String[] roles;

        private UserBuilder(String username) {
            this.username = username;
        }

        public UserBuilder password(String password) {
            this.password = password;
            return this;
        }

        public UserBuilder roles(String... roles) {
            this.roles = roles;
            return this;
        }

        public User build() {
            return new User(username, password, roles);
        }
    }
}