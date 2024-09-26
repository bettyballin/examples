<html>
  <body>
    <form>
      <input type="text" id="myInput" />
      <button onclick="doSomething()">Do something</button>
      <input type="submit" />
    </form>
    <script>
      function doSomething() {
        var inputValue = document.getElementById("myInput").value;
        alert("You entered: " + inputValue);
      }
    </script>
  </body>
</html>