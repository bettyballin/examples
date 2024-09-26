public class Temp1738 {
    public static void main(String[] args) {
        System.out.println("login.salesforce.com");

        System.out.println(";; global options: +cmd");
        System.out.println(";; Got answer:");
        System.out.println(";; ->>HEADER<<- opcode: QUERY, status: NOERROR, id: 28719");
        System.out.println(";; flags: qr rd ra; QUERY: 1, ANSWER: 5, AUTHORITY: 0, ADDITIONAL: 0");

        System.out.println(";; QUESTION SECTION:");
        System.out.println(";login.salesforce.com.      IN  A");

        System.out.println(";; ANSWER SECTION:");
        System.out.println("login.salesforce.com.   2288    IN  CNAME   login.gslb2.salesforce.com.");
        System.out.println("login.gslb2.salesforce.com. 57  IN  A   136.147.59.44");
        System.out.println("login.gslb2.salesforce.com. 57  IN  A   136.147.57.172");
        System.out.println("login.gslb2.salesforce.com. 57  IN  A   136.147.58.44");
        System.out.println("login.gslb2.salesforce.com. 57  IN  A   136.147.58.172");
    }
}