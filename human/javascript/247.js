<!DOCTYPE html>
<html>
<head>
</head>
<body data-userdoc="&lt;html&gt;&lt;head&gt;&lt;/head&gt;&lt;body&gt;This could be unsafe&lt;/body&gt;&lt;/html&gt;">
  <script>
    var unsafeDoc = new Blob([document.body.dataset.userdoc], {type: 'text/html'});
    var iframe = document.createElement('iframe');
    iframe.src = window.URL.createObjectURL(unsafeDoc);
    iframe.sandbox = 'allow-scripts';
    document.body.appendChild(iframe);
  </script>
</body>
</html>