public class Temp3272 {
    public static void main(String[] args) {
        String realm = "myRealm";
        String alias = "myAlias";
        String url = "/" + realm + "/identity-provider/instances/" + alias + "/mappers";
        System.out.println("POST " + url);
    }
}