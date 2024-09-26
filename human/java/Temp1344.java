public class Temp1344 {
    public static void main(String[] args) {
        String rules = """
        {
          "rules": {
            ".read": "auth != null", //non-authorised users CANT read
            ".write": "auth != null" //non-authorised users CANT write
          }
        }
        """;
        System.out.println(rules);
    }
}