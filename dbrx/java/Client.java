public class Client {

    private String clientId;
    private String clientSecret;

    public Client(String clientId, String clientSecret) {
        this.clientId = clientId;
        this.clientSecret = clientSecret;
    }

    public String getClientId() {
        return clientId;
    }

    public void setClientId(String clientId) {
        this.clientId = clientId;
    }

    public String getClientSecret() {
        return clientSecret;
    }

    public void setClientSecret(String clientSecret) {
        this.clientSecret = clientSecret;
    }
    
    public static void main(String[] args) {
        Client client = new Client("id123", "secretXYZ");
        System.out.println("Client ID: " + client.getClientId());
        System.out.println("Client Secret: " + client.getClientSecret());
    }
}