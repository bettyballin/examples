public class Temp3437 {
    public static void main(String[] args) {
        String loginPageUrl = "/index?showDialog=true";
        formLogin(loginPageUrl);
    }

    public static void formLogin(String loginPageUrl) {
        System.out.println("Redirecting to login page: " + loginPageUrl);
    }
}