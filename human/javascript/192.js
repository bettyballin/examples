<!DOCTYPE html>
<html>
<head>
  <title>Counter</title>
</head>
<body>
  <p id="demo">0</p>
  <button id="do-count">Count</button>
  <script>
    var a = 0;
    function count() {
      a++;
      document.getElementById('demo').textContent = a;
    }
    document.getElementById('do-count').onclick = count;
  </script>
</body>
</html>