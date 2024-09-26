<!DOCTYPE html>
<html>
  <head>
    <title>Disable Context Menu</title>
  </head>
  <body>
    <script>
      document.addEventListener('contextmenu', event => event.preventDefault());
    </script>
  </body>
</html>