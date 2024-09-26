html
<!DOCTYPE html>
<html>
<head>
    <title>Java Applet Example</title>
    <script type="text/javascript" src="https://www.java.com/js/deployJava.js"></script>
    <script type="text/javascript">
        var attributes = {
            id: "myApplet",
            name: "myApplet",
            code: "MyApplet.class",
            mayscript: "true",
            scriptable: "true",
            archive: "/path(s)/to/jar(s)",
            width: 0,
            height: 0
        };

        var params = {
            "AppletReady": "appletInitialized",
        };

        deployJava.runApplet(attributes, params, "1.8.0");

        function appletInitialized(myString, someOtherArgument) {
            // do something with your parameters
            // NOTE: do NOT call alert() from this function! 
            // Because it will most likely cause your browser to freeze, 
            // I've found that's also one of the things Java doesn't like.
        };
    </script>
</head>
<body>
    <h1>Java Applet Embed Example</h1>
    <p>If Java is enabled in your browser, the applet will be loaded.</p>
</body>
</html>