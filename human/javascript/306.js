<html>
  <head>
    <script type="text/javascript" src="https://www.java.com/js/deployJava.js"></script>
  </head>
  <body>
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
        console.log(myString, someOtherArgument);
        // do something with your parameters
      }
    </script>
  </body>
</html>