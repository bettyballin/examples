public class Temp175 {
    public static void main(String[] args) {
        // Assuming the Policy class exists and has a constructor that takes two strings
        Policy policy = new Policy("image-policy", "user:admin");
        System.out.println(policy);
    }
}

class Policy {
    private String policyName;
    private String userRole;

    public Policy(String policyName, String userRole) {
        this.policyName = policyName;
        this.userRole = userRole;
    }

    @Override
    public String toString() {
        return "Policy{" +
                "policyName='" + policyName + '\'' +
                ", userRole='" + userRole + '\'' +
                '}';
    }
}