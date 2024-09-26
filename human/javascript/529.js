html
<!DOCTYPE html>
<html>
<head>
  <title>Executable JavaScript Code</title>
</head>
<body>
  <div id="data">{"foo": "bar"}</div>
  <script>
    var data = JSON.parse(document.querySelector('#data').innerHTML);
    alert(data.foo);
  </script>
</body>
</html>