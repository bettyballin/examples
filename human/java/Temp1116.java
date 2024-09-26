public class Temp1116 {
    public static void main(String[] args) {
        String[] addresses = {
            "127.0.0.1       localhost     <replace-me>.local",
            "255.255.255.255 broadcasthost",
            "::1             localhost",
            "fe80::1%lo0     localhost"
        };

        for (String address : addresses) {
            System.out.println(address);
        }
    }
}