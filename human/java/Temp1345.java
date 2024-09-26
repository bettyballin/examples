public class Temp1345 {
    public static void main(String[] args) {
        String jsonString = """
        {
            "rules": {
                ".read": "auth == null", //even non-authorised users CAN read
                ".write": "auth == null" //even non-authorised users CAN write
            }
        }
        """;

        System.out.println(jsonString);
    }
}