public class Temp2349 {
    public static void main(String[] args) {
        String password = "examplePassword";
        String salt = "exampleSalt";
        String merged = password + "{" + salt.toString() + "}";
        System.out.println(merged);
    }
}