<html>
  <body>
    <div id="myElement">Selectable text</div>
    <script>
      const element = document.getElementById('myElement');
      element.onselectstart = function () { return false; }
    </script>
  </body>
</html>