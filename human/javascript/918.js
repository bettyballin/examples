<!DOCTYPE html>
<html>
<head>
  <title>Executable Code</title>
</head>
<body>
  <button id="element-id">Click Me</button>
  <script>
    document.querySelector("#element-id").addEventListener("click", function() {
      alert("Button clicked!");
    });
  </script>
</body>
</html>