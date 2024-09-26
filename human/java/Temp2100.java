public class Temp2100 {
    public static void main(String[] args) {
        // Original XML content as a string
        String xmlContent = 
            "<!-- Original --> \n" +
            "<authentication-manager alias=\"authenticationManager\"\n" +
            "        xmlns=\"http://www.springframework.org/schema/security\">\n" +
            "        <authentication-provider>\n" +
            "            <user-service id=\"userDetailsService\">\n" +
            "                <user name=\"marissa\" password=\"koala\" authorities=\"ROLE_USER\" />\n" +
            "                <user name=\"paul\" password=\"emu\" authorities=\"ROLE_USER\" />\n" +
            "            </user-service>\n" +
            "        </authentication-provider>\n" +
            "    </authentication-manager>";

        // Print the XML content
        System.out.println(xmlContent);
    }
}