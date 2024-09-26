<!DOCTYPE html>
<html>
<head>
  <meta charset="UTF-8">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <title>Security Policy Violation Test</title>
  <script>
    document.addEventListener("securitypolicyviolation", function(e) {
      alert("Something is trying something bad!");
    });
  </script>
</head>
<body>
  <h1>Security Policy Violation Test</h1>
  <script src="https://example.com/malicious-script.js"></script>
</body>
</html>