public class Temp205 {
    public static void main(String[] args) {
        String properties = """
            <properties>
                <spring.version>3.0.1.RELEASE</spring.version>
            </properties>
        """;
        
        String dependencies = """
            <dependency>
                <groupId>org.springframework.security</groupId>
                <artifactId>spring-security-web</artifactId>
                <version>${spring.version}</version>
            </dependency>
            <dependency>
                <groupId>org.springframework.security</groupId>
                <artifactId>spring-security-config</artifactId>
                <version>${spring.version}</version>
            </dependency>
            <dependency>
                <groupId>org.springframework.security</groupId>
                <artifactId>spring-security-taglibs</artifactId>
                <version>${spring.version}</version>
            </dependency>
            <dependency>
                <groupId>org.springframework.security</groupId>
                <artifactId>spring-security-core</artifactId>
                <version>${spring.version}</version>
            </dependency>
        """;
        
        System.out.println(properties);
        System.out.println(dependencies);
    }
}