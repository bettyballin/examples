<!DOCTYPE html>
<html>
  <body>
    <div id="userName"></div>
    <script>
      let name = "<script>alert('You are hacked!')</script>";
      var userNameElement = document.getElementById("userName");
      var txtNode = document.createTextNode(name);
      userNameElement.appendChild(txtNode);
    </script>
  </body>
</html>