public class CustomSecurityContext {
    private static final ThreadLocal<Authentication> SECURITY_CONTEXT = new InheritableThreadLocal<>();

    public static void set(Authentication authentication) {
        if (authentication != null && (SECURITY_CONTEXT.get() == null || !SECURITY_CONTEXT.get().equals(authentication))) {
            SECURITY_CONTEXT.set(authentication);
        }
    }

    public static Authentication get() {
        return SECURITY_CONTEXT.get();
    }

    // Clear the context when needed
    public static void clear() {
        SECURITY_CONTEXT.remove();
    }

    public static void main(String[] args) {
        Authentication auth1 = new Authentication("user1", "token1");
        Authentication auth2 = new Authentication("user2", "token2");
        
        CustomSecurityContext.set(auth1);
        System.out.println("Current Authentication: " + CustomSecurityContext.get());

        CustomSecurityContext.set(auth2);
        System.out.println("Updated Authentication: " + CustomSecurityContext.get());

        CustomSecurityContext.clear();
        System.out.println("Cleared Authentication: " + CustomSecurityContext.get());
    }
}

class Authentication {
    private String username;
    private String token;

    public Authentication(String username, String token) {
        this.username = username;
        this.token = token;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;

        Authentication that = (Authentication) obj;

        if (!username.equals(that.username)) return false;
        return token.equals(that.token);
    }

    @Override
    public int hashCode() {
        int result = username.hashCode();
        result = 31 * result + token.hashCode();
        return result;
    }

    @Override
    public String toString() {
        return "Authentication{" +
                "username='" + username + '\'' +
                ", token='" + token + '\'' +
                '}';
    }
}