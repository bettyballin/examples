public class Temp203 {
    private String loginUsername;

    public Temp203(String loginUsername) {
        this.loginUsername = loginUsername;
    }

    public static void main(String[] args) {
        Temp203 temp = new Temp203("user123");
        System.out.println("HashCode: " + temp.hashCode());
    }

    @Override
    public int hashCode() {
        return loginUsername == null ? 0 : loginUsername.hashCode();
    }
}