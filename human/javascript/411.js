<html>
  <head>
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.0/jquery.min.js"></script>
  </head>
  <body>
    <input type='text' id='userName' />
    <input type="password" id="password"/>
    <input class="button" name="submit" type="submit" id="submitLogin" value="Login"/>
    <script>
      $(document).ready(function(){
        $('#submitLogin').click(function(){
          var userName = $('#userName').val();
          var password = $('#password').val();
          // Add your login logic here
          console.log('Username: ' + userName + ', Password: ' + password);
        });
      });
    </script>
  </body>
</html>