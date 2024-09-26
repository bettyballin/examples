<?php
$mysqli = new mysqli("localhost", "username", "password", "database");

if ($mysqli->connect_errno) {
    echo "Failed to connect to MySQL: (" . $mysqli->connect_errno . ") " . $mysqli->connect_error;
    exit();
}

$stmt = $mysqli->prepare("SELECT * FROM users WHERE username=? AND password=?");
$stmt->bind_param("ss", $username, $password);

$username = $_POST['username'];
$password = md5($_POST['password']);

$stmt->execute();
$result = $stmt->get_result();

if($result->num_rows === 1) {
    echo "User found";
} else {
    echo "No user found";
}

$stmt->close();
$mysqli->close();
?>