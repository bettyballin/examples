html
<html>
  <body>
    <script>
      (function() {
        'use strict';
        var defl = 'https://example.com/definition.html';
        var fr = document.createElement('iframe');
        fr.src = defl;
        fr.style.maxWidth="90%";
        document.body.appendChild(fr);
      })();
    </script>
  </body>
</html>