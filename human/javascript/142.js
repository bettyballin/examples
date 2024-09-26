<!DOCTYPE html>
<html>
<head>
  <title>Executable Code</title>
</head>
<body>
  <input id="myInput" type="text">
  <script>
    window.onload = () => {
      const myInput = document.getElementById('myInput');
      myInput.onpaste = e => e.preventDefault();
    }
  </script>
</body>
</html>