public class Temp1924 {

    public static void main(String[] args) {
        Temp1924 temp = new Temp1924();
        temp.initialize();
    }

    protected void initialize() {
        // ...

        setUsersByUsernameQuery("SELECT username, password FROM `user` WHERE username = ?");

        String roleSql = "SELECT u.username, r.name"
                + "  FROM user_roles ur JOIN `role` r ON (ur.role_id=r.id)"
                + "       JOIN `user` u on(u.id=ur.user_id) WHERE username =?";
        setAuthoritiesByUsernameQuery(roleSql);
    }

    private void setUsersByUsernameQuery(String query) {
        // This is a mock implementation for demonstration.
        System.out.println("UsersByUsernameQuery: " + query);
    }

    private void setAuthoritiesByUsernameQuery(String query) {
        // This is a mock implementation for demonstration.
        System.out.println("AuthoritiesByUsernameQuery: " + query);
    }
}