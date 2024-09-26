public class Temp3709 {
    public static void main(String[] args) {
        System.out.println("Dependency included in build file.");
    }
}


For Maven:
xml
<dependency>
    <groupId>org.springframework.cloud</groupId>
    <artifactId>spring-cloud-starter-bootstrap</artifactId>
</dependency>


For Gradle:
gradle
implementation 'org.springframework.cloud:spring-cloud-starter-bootstrap'