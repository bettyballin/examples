public class Temp1471 {
    public static void main(String[] args) {
        Temp1471 temp = new Temp1471();
        UserDetails user = temp.loadUserByUsername("example@example.com");
        System.out.println(user);
    }

    public UserDetails loadUserByUsername(final String email) {
        // Dummy implementation for demonstration
        return new UserDetails(email, "User Name");
    }

    class UserDetails {
        private String email;
        private String name;

        public UserDetails(String email, String name) {
            this.email = email;
            this.name = name;
        }

        @Override
        public String toString() {
            return "UserDetails{" +
                    "email='" + email + '\'' +
                    ", name='" + name + '\'' +
                    '}';
        }
    }
}