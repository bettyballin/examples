<html>
  <head>
    <script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
  </head>
  <body>
    <input type="text" id="userName" placeholder="Username">
    <input type="password" id="password" placeholder="Password">
    <button id="submitLogin" disabled>Submit</button>

    <script>
      $(document).ready(function() {

        if ($("#userName").val().length !== 0 && $.trim($('#userName').val()) !== '' && $("#password").val().length !== 0 && $.trim($('#password').val()) !== '') {

          $('#submitLogin').removeAttr('disabled');
        } else {
          $('#submitLogin').attr('disabled', "");
        }

        $('input').on('change keyup  blur mouseenter ', function(e) {


          if ($("#userName").val().length !== 0 && $.trim($('#userName').val()) !== '' && $("#password").val().length !== 0 && $.trim($('#password').val()) !== '') {

            $('#submitLogin').removeAttr('disabled');
          } else {
            $('#submitLogin').attr('disabled', "");
          }

        });
      });
    </script>
  </body>
</html>