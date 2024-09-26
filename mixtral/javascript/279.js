<!DOCTYPE html>
<html>
  <head>
    <meta charset="UTF-8">
  </head>
  <body>
    <div></div>
    <script>
      const html = new window.TrustedTypePolicyFactory().createHTML("<p>Hello World</p>");
      document.querySelector('div').innerHTML = html;
    </script>
  </body>
</html>