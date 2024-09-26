public class Temp1151 {
    public static void main(String[] args) {
        String ruleset = "<ruleset version=\"1.0+\">\n" +
                "  <rule> <!-- allow anything signed with company's public cert --> \n" +
                "    <id location=\"http://10.190.65.254/myapp\">\n" +
                "    </id>\n" +
                "    <action permission=\"run\"/>\n" +
                "  </rule>\n" +
                "\n" +
                "  <rule>\n" +
                "    <id />\n" +
                "    <action permission=\"default\"/>\n" +
                "  </rule>\n" +
                "</ruleset>";

        System.out.println(ruleset);
    }
}