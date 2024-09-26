<!DOCTYPE html>
<html>
<head>
  <title>Executable Code</title>
</head>
<body>
  <h1 id="header"></h1>
  <script>
    const winT = "Example Title";
    const safeTitle = encodeURIComponent(winT);
    document.getElementById("header").textContent = decodeURIComponent(safeTitle);
  </script>
</body>
</html>