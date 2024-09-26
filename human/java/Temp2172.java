public class Temp2172 {
    public static void main(String[] args) {
        String profiles = """
            <profiles>
                <profile>
                    <id>profile1</id>
                    <build>
                        <plugins>
                            <plugin>
                                <groupId>org.apache.maven.plugins</groupId>
                                <artifactId>maven-compiler-plugin</artifactId>
                                <configuration>
                                    <includes>
                                        <include>**/*</include>
                                    </includes>
                                    <excludes>
                                        <exclude>com/xxx/xxx/config/ApplicationContextSecuritySAML.java</exclude>
                                    </excludes>
                                </configuration>
                            </plugin>
                        </plugins>
                    </build>
                </profile>
                <profile>
                    <id>profile2</id>
                    <build>
                        <plugins>
                            <plugin>
                                <groupId>org.apache.maven.plugins</groupId>
                                <artifactId>maven-compiler-plugin</artifactId>
                                <configuration>
                                    <includes>
                                        <include>**/*</include>
                                    </includes>
                                    <excludes>
                                        <exclude>com/xxx/xxx/config/ApplicationContextSecurity.java</exclude>
                                    </excludes>
                                </configuration>
                            </plugin>
                        </plugins>
                    </build>
                </profile>
            </profiles>
        """;
        
        System.out.println(profiles);
    }
}