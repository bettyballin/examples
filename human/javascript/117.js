<!DOCTYPE html>
<html>
<head>
  <script src="http://caja.appspot.com/html-css-sanitizer-minified.js"></script>
</head>
<body>
  <script>
    var untrustedCode = '<p>Hello, <script>alert("XSS")</script> world!</p>';
    var sanitized = html_sanitize(untrustedCode,
      function(url) { return url },
      function(id) { return id; });
    console.log(sanitized);
    document.write(sanitized);
  </script>
</body>
</html>