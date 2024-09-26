public class Temp3049 {
    public static void main(String[] args) {
        String serverToClientMessage1 = "server <- client: encrypted password";
        String serverToClientMessage2 = "server -> client: 256-bit access token";
        String clientToServerMessage1 = "server <- client: 256-bit access token";
        String clientToServerMessage2 = "server <- client: 256-bit access token";

        System.out.println(serverToClientMessage1);
        System.out.println(serverToClientMessage2);
        System.out.println(clientToServerMessage1);
        System.out.println(clientToServerMessage2);
    }
}