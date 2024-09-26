<!DOCTYPE html>
<html>
<head>
  <title>Iframe Load Event</title>
</head>
<body>
  <iframe src="https://example.com" frameborder="0" width="100%" height="500"></iframe>
  <script>
    const iframe = document.querySelector('iframe');

    iframe.addEventListener('load', () => {
      console.log('Iframe is loaded');
      // Your code to run when the iframe is loaded
    });
  </script>
</body>
</html>