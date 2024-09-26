<?php
$mysqli = new mysqli("localhost", "username", "password", "database");

if ($mysqli->connect_error) {
    die("Connection failed: " . $mysqli->connect_error);
}

$query = $mysqli->prepare('SELECT * FROM users WHERE id = ? AND check = ?');
$query->bind_param('ii', $_GET['id'], $_POST['check']);
$query->execute();
$result = $query->get_result();
while ($row = $result->fetch_assoc()) {
    // your code here
    print_r($row);
}
$mysqli->close();
?>