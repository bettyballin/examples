php
<?php
$conn = mysqli_connect("localhost", "username", "password", "database");

if (!$conn) {
  die("Connection failed: " . mysqli_connect_error());
}

$id = mysqli_real_escape_string($conn, $_GET['id']);
$sql = "SELECT * FROM `menubalk` WHERE `webnr` LIKE '%$webnr-%' AND `hoofdgroep` = '$id' ORDER BY `naamt1` ASC";

$result = mysqli_query($conn, $sql);

if (mysqli_num_rows($result) > 0) {
  while($row = mysqli_fetch_assoc($result)) {
    print_r($row);
  }
} else {
  echo "0 results";
}

mysqli_close($conn);
?>