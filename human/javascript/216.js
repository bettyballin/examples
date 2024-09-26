<!DOCTYPE html>
<html>
<head>
  <script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
</head>
<body>

<div id='form_placeholder' style='display:none'>
  <form>
    <input type="text" name="cat"/>
    <input type="submit" value="submit" name="submit"/>
  </form>
</div>

<script type='text/javascript'>
  $(document).ready(function(){
    $('#form_placeholder').show();
  });
</script>

</body>
</html>