<!DOCTYPE html>
<html>
<head>
  <script src="https://cdnjs.cloudflare.com/ajax/libs/dompurify/2.3.4/purify.min.js"></script>
</head>
<body>
  <h1 id="header"></h1>
  <script>
    const winT = "YOUR TEXT HERE";
    const sanitizedWinT = DOMPurify.sanitize(winT);
    document.getElementById("header").textContent = sanitizedWinT;
  </script>
</body>
</html>