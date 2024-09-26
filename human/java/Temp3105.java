public class Main {
    public static void main(String[] args) {
        String[] classpaths = {
            "classpath:/META-INF/resources/",
            "classpath:/resources/",
            "classpath:/static/",
            "classpath:/public/",
            "/"
        };

        for (String path : classpaths) {
            System.out.println(path);
        }
    }
}