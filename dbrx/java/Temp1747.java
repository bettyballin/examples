public class Temp1747 {
    public static void main(String[] args) {
        String publicKeyString = "ssh-rsa AAAAB3NzaC1yc2EAAAABIwAAAQEArD2... user@hostname";
        publicKeyString = publicKeyString.replaceAll("ssh-rsa\\s+", "").replaceAll("\\s.*$", "");
        System.out.println(publicKeyString);
    }
}