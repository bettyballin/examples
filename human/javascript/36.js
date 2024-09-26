html
<!DOCTYPE html>
<html>
<head>
  <title>Executable Code</title>
</head>
<body>
  <form id="form_main" name="form_main" action="/search/" target="iframe001" method="get" onSubmit="return reset_and_subm();">
    <div style="display: none;"><input type="text" name="ie6"></div>
    <input name="nav_querystring" type="text" id="nav_querystring" style="width: 240px; font-family:Arial, Helvetica, sans-serif; font-size:12px; font-weight:bold;" value="">
    <input type="submit" name="nav_submit" id="nav_submit" value="Sök" style="width: 55px; font-size: 13px;">
  </form>
  <script>
    function reset_and_subm() {
      // Add your reset and submit logic here
      return true;
    }
  </script>
</body>
</html>