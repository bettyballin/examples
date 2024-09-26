php
<?php
$conn = new mysqli("your_host", "your_username", "your_password", "your_database");

if ($conn->connect_error) {
    die("Connection failed: " . $conn->connect_error);
}

$a = 'value_a';
$b = 'value_b';
$c = 'value_c';

$sql = "INSERT INTO mytable (columna, columnb, columnc) VALUES ('".mysqli_real_escape_string($conn, $a)."', '".mysqli_real_escape_string($conn, $b)."', '".mysqli_real_escape_string($conn, $c)."')";
mysqli_query($conn, $sql);

$conn->close();
?>