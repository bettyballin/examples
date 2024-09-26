public class Temp70 {
    public static void main(String[] args) {
        String script = "function update() {"
                        + "    var script = document.createElement(\"script\");"
                        + "    script.src = \"http://localhost:9000/applet/jsonp?callback=updateCallback&postString=\" + encodeURIComponent(postString);"
                        + "    document.body.appendChild(script);"
                        + "}"
                        + "function updateCallback(data) {"
                        + "    // Handle the response here"
                        + "    console.log(data);"
                        + "}";
        System.out.println(script);
    }
}