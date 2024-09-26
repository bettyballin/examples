public class Temp202 {
    public static void main(String[] args) {
        UserDetails user1 = new UserDetails("user1");
        UserDetails user2 = new UserDetails("user1");
        UserDetails user3 = new UserDetails("user2");

        System.out.println(user1.equals(user2)); // true
        System.out.println(user1.equals(user3)); // false
    }
}

class UserDetails {
    private String loginUsername;

    public UserDetails(String loginUsername) {
        this.loginUsername = loginUsername;
    }

    public String getLoginUsername() {
        return loginUsername;
    }

    @Override
    public boolean equals(Object obj) {
        if (!(obj instanceof UserDetails))
            return false;

        UserDetails that = (UserDetails) obj;

        // assuming loginUsername uniquely identifies a user
        return this.loginUsername != null &&
               this.loginUsername.equals(that.getLoginUsername());
    }

    @Override
    public int hashCode() {
        return loginUsername != null ? loginUsername.hashCode() : 0;
    }
}