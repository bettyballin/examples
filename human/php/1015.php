<?php
$val1 = 'value1';
$val2 = 'value2';

$conn = new mysqli('localhost', 'username', 'password', 'database');

if ($conn->connect_error) {
    die("Connection failed: " . $conn->connect_error);
}

$query = "SELECT a, b FROM t WHERE x = ? AND y = ?";

$stmt = $conn->prepare($query);
$stmt->bind_param("ss", $val1, $val2);
$stmt->execute();
$result = $stmt->get_result();

while($row = $result->fetch_assoc()) {
    print_r($row);
}

$stmt->close();
$conn->close();
?>