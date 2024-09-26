<html>
  <head>
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>
  </head>
  <body>
    <button onclick="insert()">Insert</button>
    <script>
      function insert() {
        $.post("test.php", { messageid: "1" });
      }
    </script>
  </body>
</html>