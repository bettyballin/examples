// Assuming UserService and UserDetails are defined elsewhere in your project
public class Temp1095 {
    private final UserService userService;

    public Temp1095(UserService userService) {
        this.userService = userService;
    }

    public UserDetails loadUserByUsername(String ssoId) throws UsernameNotFoundException {
        // rest of the code
        return null; // placeholder return statement
    }

    public static void main(String[] args) {
        // Assuming UserService has a no-argument constructor or modify accordingly
        UserService userService = new UserService();
        Temp1095 temp1095 = new Temp1095(userService);
        try {
            temp1095.loadUserByUsername("exampleSsoId");
        } catch (UsernameNotFoundException e) {
            e.printStackTrace();
        }
    }
}