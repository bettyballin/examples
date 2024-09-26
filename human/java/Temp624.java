public class Temp624 {
    private boolean isAdmin;

    public boolean isAdmin() {
        return this.isAdmin;
    }

    public void setAdmin(boolean value) {
        this.isAdmin = value;
    }

    public static void main(String[] args) {
        Temp624 temp = new Temp624();
        temp.setAdmin(true);
        System.out.println("Is Admin: " + temp.isAdmin());
    }
}