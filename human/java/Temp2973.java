public class Temp2973 {
    public static void main(String[] args) {
        // This block of code does not make sense in Java context
        // Assuming the aim is to print the JSON-like structure as a string
        String jsonConfig = """
        {
          "/api": {
            "target": "http://localhost:8080/",
            "changeOrigin": true,
            "secure": false,
            "pathRewrite": {
               "^/api": ""
             }
           }
        }
        """;
        
        System.out.println(jsonConfig);
    }
}