<?php
$mysqli = new mysqli("localhost", "username", "password", "database");

if ($mysqli->connect_errno) {
    printf("Connect failed: %s\n", $mysqli->connect_error);
    exit();
}

$status = 1;
$category = 1;

$stmt = $mysqli->prepare("SELECT *, date_format(date, '%d') AS day, date_format(date, '%m') AS month, date_format(date, '%Y') AS year FROM articles WHERE status = ? AND category = ? ORDER BY datePub DESC LIMIT 10");
$stmt->bind_param("ii", $status, $category);
$stmt->execute();
$result = $stmt->get_result();

while($row = $result->fetch_assoc()) {
    print_r($row);
}

$stmt->close();
$mysqli->close();
?>