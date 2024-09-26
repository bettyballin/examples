<html>
  <head>
    <script src="http://ajax.googleapis.com/ajax/libs/jquery/1.4.2/jquery.min.js"></script>
    <script type="text/javascript">
      $(document).ready(function(){
        function sendData(data)
        {
          var response;
          $.ajax({
            url: 'phpservice.php',
            data: data,
            type: 'POST',
            dataType: 'json',
            async: false,
            success: function(response_from_service)
            {
              response = response_from_service;
            },
            error: function()
            {
            }
          });
          return response;
        };
        function getData(data)
        {
          var response;
          $.ajax({
            url: 'phpservice.php',
            data: data,
            type: 'GET',
            dataType: 'json',
            async: false,
            success: function(response_from_service)
            {
              response = response_from_service;
            },
            error: function()
            {
            }
          });
          return response;
        };
        // Call the functions to test them
        var data = { test: "Hello, World!" };
        console.log(sendData(data));
        console.log(getData(data));
      });
    </script>
  </head>
  <body>
  </body>
</html>