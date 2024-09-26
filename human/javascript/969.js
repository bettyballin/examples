<!DOCTYPE html>
<html>
  <head>
    <meta charset="UTF-8">
    <title>Executable Iframe</title>
  </head>
  <body>
    <iframe csp="default-src 'none'" srcdoc="something"></iframe>
    <script>
      const iframe = document.querySelector('iframe');
      iframe.srcdoc = '<script>alert(" Executed!")<\/script>';
    </script>
  </body>
</html>