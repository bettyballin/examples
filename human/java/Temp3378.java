public class Temp3378 {
    public static void main(String[] args) {
        String rules = "{\n" +
                "  \"rules\": {\n" +
                "    \"users\": {\n" +
                "      \"$userId\": {\n" +
                "        \".read\": \"$userId === auth.uid\",\n" +
                "        \".write\": \"$userId === auth.uid\"\n" +
                "      }\n" +
                "    }\n" +
                "  }\n" +
                "}";
        
        System.out.println(rules);
    }
}