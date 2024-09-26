public class Temp172 {
    private String storedHashedPassword = "exampleHashedPassword";

    public static void main(String[] args) {
        Temp172 temp = new Temp172();
        System.out.println(temp.getPassword());
    }

    public String getPassword() {
        return "{noop}" + this.storedHashedPassword;
    }
}