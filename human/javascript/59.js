<!DOCTYPE html>
<html>
<head>
  <title>Session Timeout</title>
</head>
<body>
  <script>
    setTimeout(function() {
      if(confirm('Session timeout. Please login again.')) {
        location.href = 'login.html';
      }
    }, 15 * 60 * 1000); // 15 minutes
  </script>
</body>
</html>