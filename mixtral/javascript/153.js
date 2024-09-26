<html>
  <head>
    <script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
  </head>
  <body>
    <div id="selector"></div>
    <script>
      var getV = document.currentScript.src.split("?v=")[1];
      getV = encodeURIComponent(getV);
      $(document).ready(function() {
        $("#selector").text('Your text here with inserted variable ' + decodeURIComponent(getV));
      });
    </script>
  </body>
</html>