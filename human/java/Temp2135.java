public class Temp2135 {
    public static void main(String[] args) {
        SecurityPOJO securityPOJO = new SecurityPOJO("exampleName");
        System.err.println("ERROR: AFTER: " + securityPOJO.getName());
    }
}

class SecurityPOJO {
    private String name;

    public SecurityPOJO(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}