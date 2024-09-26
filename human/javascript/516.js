<!DOCTYPE html>
<html>
<head>
  <script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
</head>
<body class="PageClass">
  <script>
    $(function(){
      if($('body').hasClass('PageClass')){
        console.log('The body has the class "PageClass"');
      }
    });
  </script>
</body>
</html>