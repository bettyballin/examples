public class Temp24 {
    public static void main(String[] args) {
        System.out.println(casAuthenticationProvider());
    }

    public static CasAuthenticationProvider casAuthenticationProvider() {
        return new CasAuthenticationProvider();
    }

    static class CasAuthenticationProvider {
        @Override
        public String toString() {
            return "CasAuthenticationProvider instance created";
        }
    }
}