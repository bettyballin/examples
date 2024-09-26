public class Temp1807 {
    public static void main(String[] args) {
        System.out.println("Executing Temp1807...");
        
        Rule rule1 = new Rule("https://java.com/", "run", "SECURE");
        Rule rule2 = new Rule("http://climate.example.com/", "run", "1.6.0_31");

        System.out.println(rule1);
        System.out.println(rule2);
    }
}

class Rule {
    private String location;
    private String permission;
    private String version;

    public Rule(String location, String permission, String version) {
        this.location = location;
        this.permission = permission;
        this.version = version;
    }

    @Override
    public String toString() {
        return "Rule{" +
               "location='" + location + '\'' +
               ", permission='" + permission + '\'' +
               ", version='" + version + '\'' +
               '}';
    }
}