public class Temp2551 {
    public static void main(String[] args) {
        String security = "oauth2:\n" +
                "    resource:\n" +
                "        user-info-uri: http://localhost:9090/account/userInfo.json\n" +
                "        preferTokenInfo: false";
        
        System.out.println(security);
    }
}