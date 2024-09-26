html
<html>
  <body>
    <iframe id="foo"></iframe>
    <script>
      var sandboxSupported = "sandbox" in document.createElement("iframe");

      if (sandboxSupported) {
          document.getElementById('foo').setAttribute('src', 'https://www.example.org/show_user_script.aspx?id=123');
      }
      else
      {
          // Not safe to display IFrame
          document.getElementById('foo').innerHTML = "Not safe to display IFrame";
      }
    </script>
  </body>
</html>