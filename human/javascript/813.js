<!DOCTYPE html>
<html>
<head>
  <title>News Alert</title>
</head>
<body>
  <input type="text" id="news" placeholder="Enter news">
  <button onclick="GetResult()">Get Result</button>
  <script>
    function GetResult() {
      var news = document.getElementById('news').value;
      alert(news);
    }
  </script>
</body>
</html>