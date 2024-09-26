public class Temp1694 {
    public static void main(String[] args) {
        Principal principal = new Principal(1);
        int empId = 1;

        if(principal.getId() == empId) {
            System.out.println("PROCEED...");
        } else {
            System.out.println("STOP! GO TO 403!");
        }
    }
}

class Principal {
    private int id;

    public Principal(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }
}