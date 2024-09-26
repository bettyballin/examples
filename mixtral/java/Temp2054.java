public class Temp2054 {
    public static void main(String[] args) {
        try {
            UserDetails user = loadUserByUsername("example@example.com");
            System.out.println("User loaded: " + user);
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    public static UserDetails loadUserByUsername(String email) throws Exception {
        Members members = MembersDao.findByEmail(email);

        // If no such username exists throw a custom exception
        if (members == null) {
            throw new Exception("User not found");
        }

        return new UserDetails(members);
    }
}

class Members {
    private String email;

    public Members(String email) {
        this.email = email;
    }

    public String getEmail() {
        return email;
    }
}

class MembersDao {
    public static Members findByEmail(String email) {
        // Simulate a database lookup
        if ("example@example.com".equals(email)) {
            return new Members(email);
        }
        return null;
    }
}

class UserDetails {
    private Members members;

    public UserDetails(Members members) {
        this.members = members;
    }

    @Override
    public String toString() {
        return "UserDetails{email=" + members.getEmail() + "}";
    }
}