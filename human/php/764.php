<?php
$id = 1; // replace with your desired id
$sql = "UPDATE `novels` SET `count`=`count`+1 WHERE `id`=".(int)$id;
$conn = new mysqli("localhost", "username", "password", "database");
if ($conn->connect_error) {
  die("Connection failed: " . $conn->connect_error);
}
if ($conn->query($sql) === TRUE) {
  echo "Record updated successfully";
} else {
  echo "Error updating record: " . $conn->error;
}
$conn->close();
?>