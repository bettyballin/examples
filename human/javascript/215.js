<!DOCTYPE html>
<html>
<head>
  <script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
</head>
<body>
  <div id='form_placeholder'></div>

  <script type='text/javascript'>
    var form='<form><input type="text" name="cat"/><input type="submit" value="submit" name="submit"/></form>';

    $(document).ready(function(){
      $('#form_placeholder').html(form);
    });
  </script>
</body>
</html>