<?php
$mysqli = new mysqli("localhost", "username", "password", "database_name");

if ($mysqli->connect_error) {
    die("Connection failed: " . $mysqli->connect_error);
}

$target = "%example%";
$category = 1;

$stmt = $mysqli->prepare("SELECT * FROM table_name WHERE column_name LIKE ?");
$bind_result = $stmt->bind_param("s", $target);
$execute_result = $stmt->execute();
$result = $stmt->get_result();
while ($row = $result->fetch_assoc()) {
    print_r($row);
}
$stmt->close();
$mysqli->close();
?>