<html>
  <head>
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
  </head>
  <body>
    <iframe id="iframeWindow" width="500" height="500"></iframe>
    <script>
      $(document).ready(function() {
        $("#iframeWindow").attr('src', "http://<CHILD URL>/#hello");
      });
    </script>
  </body>
</html>