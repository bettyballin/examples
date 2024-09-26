<html>
  <head>
    <script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
  </head>
  <body>
    <button onclick="insert()">Insert</button>
    <script>
      function insert() { 
        $.post("test.php", { messageid: "1" } );
      }
    </script>
  </body>
</html>