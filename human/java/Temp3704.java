public class Temp3704 {
    public static void main(String[] args) {
        String email = "example@example.com\n";
        Repository repo = new Repository();
        repo.findByEmail(email.replaceAll("\n", ""));
    }
}

class Repository {
    public void findByEmail(String email) {
        System.out.println("Finding user with email: " + email);
    }
}