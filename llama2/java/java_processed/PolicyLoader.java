public class PolicyLoader {
    public static void main(String[] args) {
        String policyFilePath = System.getenv("POLICY_FILE_PATH");
        if (policyFilePath != null) {
            // Load the policy file using the path
            System.out.println("Policy file path: " + policyFilePath);
        } else {
            System.out.println("POLICY_FILE_PATH environment variable is not set.");
        }
    }
}