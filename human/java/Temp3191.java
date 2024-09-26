import java.util.ArrayList;
import java.util.List;

import org.springframework.web.util.HtmlUtils;

public class Temp3191 {
    public static void main(String[] args) {
        List<String> result = List.of("<script>", "<b>text</b>");
        List<String> newResult = new ArrayList<>();
        for (String temp : result) {
            newResult.add(HtmlUtils.htmlEscape(temp));
        }

        System.out.println(newResult);
    }
}


Make sure to include the Spring Web dependency in your project to use `HtmlUtils`. Here is the Maven dependency for Spring Web:

xml
<dependency>
    <groupId>org.springframework</groupId>
    <artifactId>spring-web</artifactId>
    <version>5.3.10</version>
</dependency>