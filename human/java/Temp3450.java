public class Temp3450 {
    public static void main(String[] args) {
        System.out.println("Set the following JVM options to enable TLSv1.2 and TLSv1.3:");
        System.out.println("-Dhttps.protocols=\"TLSv1.2,TLSv1.3\"");
        System.out.println("-Djdk.tls.client.protocols=\"TLSv1.2,TLSv1.3\"");
    }
}