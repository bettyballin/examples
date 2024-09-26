<!DOCTYPE html>
<html>
<head>
  <title>Iframe Test</title>
</head>
<body>
  <iframe id="your-iframe" src="child.html"></iframe>

  <script>
    var iframe = document.getElementById('your-iframe');
    var origin = window.location.protocol + '://' + window.location.host;
    if (window.location.port != 80) origin += ':' + window.location.port;

    window.addEventListener('message', function(event) {
      if (event.source != iframe.contentWindow
              || event.origin != origin || event.data != "child loaded")
          return;

      console.log("Iframe loaded!");
      // do here what you used to do on the iframe's load event
    }, false);
  </script>
</body>
</html>


html
<!-- child.html -->
<!DOCTYPE html>
<html>
<head>
  <title>Child Iframe</title>
</head>
<body>
  <script>
    window.parent.postMessage("child loaded", "*");
  </script>
</body>
</html>