<html>
  <body>
    <div id="serverData">
      <input type="hidden" id="gaToken" value="YOUR_GA_TOKEN_HERE">
    </div>
    <script>
      var ga_token = document.getElementById("gaToken").value;
      (function (i, s, o, g, r, a, m) {
        i['GoogleAnalyticsObject'] = r; i[r] = i[r] || function () {
          (i[r].q=i[r].q||[]).push(arguments)},i[r].l=1*new Date();a=s.createElement(o),
          m=s.getElementsByTagName(o)[0];a.async=1;a.src=g;m.parentNode.insertBefore(a,m)
      })(window,document,'script','//www.google-analytics.com/analytics.js','ga');

      ga('create', ga_token, 'auto');
      ga('send', 'pageview');
    </script>
  </body>
</html>