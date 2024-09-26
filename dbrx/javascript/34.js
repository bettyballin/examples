<html>
  <body>
    <iframe id="my-iframe-id" src="about:blank"></iframe>
    <script>
      var iframe = document.getElementById("my-iframe-id");
      iframe.contentWindow.postMessage('Hello child! ','*');
    </script>
  </body>
</html>