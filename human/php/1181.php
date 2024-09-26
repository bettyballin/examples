<?php
$servername = "localhost";
$username = "username";
$password = "password";
$dbname = "database_name";

$conn = new mysqli($servername, $username, $password, $dbname);

if ($conn->connect_error) {
  die("Connection failed: " . $conn->connect_error);
}

$id = mysqli_real_escape_string($conn, $_GET['id']);
$webnr = mysqli_real_escape_string($conn, $_GET['webnr']); // assuming $webnr is defined somewhere

$sql = "SELECT * FROM `menubalk` WHERE `webnr` LIKE '%$webnr-%' AND `hoofdgroep` = '$id' ORDER BY `naamt1` ASC";

$result = $conn->query($sql);

if ($result->num_rows > 0) {
  while($row = $result->fetch_assoc()) {
    echo $row["column_name"] . "<br>";
  }
} else {
  echo "0 results";
}

$conn->close();
?>