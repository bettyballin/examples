<html>
  <head>
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>
  </head>
  <body>
    <input type="password" placeholder="Enter password">
    <script>
      $(document).ready(function(){
        $('input[type="password"]').on('change', function() {
          if ($(this).attr('type') !== 'password') {
            $(this).attr('type', 'password');
          }
        });
      });
    </script>
  </body>
</html>