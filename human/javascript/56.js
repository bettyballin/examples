<html>
  <body>
    <script>
      window.addEventListener("message", function(e){
        window.location.href = e.data  //navigates to newpage.html
      }, false)
    </script>
    <iframe src="newpage.html"></iframe>
    <script>
      document.querySelector('iframe').contentWindow.postMessage('newpage.html', '*');
    </script>
  </body>
</html>