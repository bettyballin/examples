public class Temp2979 {
    public static void main(String[] args) {
        sessionManagement().invalidSessionUrl("/loginForm");
    }

    public static SessionManagement sessionManagement() {
        return new SessionManagement();
    }
}

class SessionManagement {
    public SessionManagement invalidSessionUrl(String url) {
        System.out.println("Invalid session URL set to: " + url);
        return this;
    }
}