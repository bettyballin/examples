public class Temp149 {
    public static void main(String[] args) {
        String user = "JohnDoe";
        String parentGroup = "CN=parentGroup,DC=mycompany,DC=com";

        if (isMemberOfParentGroup(user, parentGroup)) {
            System.out.println("This user is " + user + " and is in a group that is a member of our parent group.");
        } else {
            System.out.println("This user is " + user + " and is not in a group that is a member of our parent group.");
        }
    }

    // Mock method to simulate membership checking
    public static boolean isMemberOfParentGroup(String user, String parentGroup) {
        // In a real application, this would query an LDAP server or similar
        // For demonstration purposes, we just return true
        return true;
    }
}