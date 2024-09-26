Here is the corrected Java code:


public class Temp1598 {
    public static void main(String[] args) {
        // Create a dummy authentication object for demonstration purposes
        Authentication authentication = new DummyAuthentication(new DummyUserDetails("dummyUsername"));

        if(authentication.getPrincipal() instanceof UserDetails) {
            String username = ((UserDetails)authentication.getPrincipal()).getUsername();
            System.out.println("Username: " + username);
        }
    }
}

interface Authentication {
    Object getPrincipal();
}

class DummyAuthentication implements Authentication {
    private UserDetails userDetails;

    public DummyAuthentication(UserDetails userDetails) {
        this.userDetails = userDetails;
    }

    @Override
    public Object getPrincipal() {
        return this.userDetails;
    }
}

interface UserDetails {
    String getUsername();
}

class DummyUserDetails implements UserDetails {
    private String username;

    public DummyUserDetails(String username) {
        this.username = username;
    }

    @Override
    public String getUsername() {
        return this.username;
    }
}


No changes were needed, the original code compiles without errors.