<?php
$conn = new mysqli("localhost", "username", "password", "database");

$a = "value1";
$b = "value2";
$c = "value3";

$sql = "INSERT INTO mytable (columna, columnb, columnc) VALUES ('".mysqli_real_escape_string($conn, $a)."', '".mysqli_real_escape_string($conn, $b)."', '".mysqli_real_escape_string($conn, $c)."')";
mysqli_query($conn, $sql);

$conn->close();
?>