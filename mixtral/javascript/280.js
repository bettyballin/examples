<!DOCTYPE html>
<html>
<head>
  <script>
    const url = new window.TrustedTypePolicyFactory().createScriptURL("https://example.com/script.js")
    document.querySelector('script').src = url;
  </script>
  <script></script>
</head>
<body>
</body>
</html>