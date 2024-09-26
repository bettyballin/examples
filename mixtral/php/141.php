<?php

$hostname = isset($_POST['hostname']) ? $mysqli->real_escape_string(trim($_POST['hostname'])) : '';
$username = isset($_POST['username']) ? $mysqli->real_escape_string(trim($_POST['username'])) : '';
$password = isset($_POST['password']) ? $mysqli->real_escape_string(trim($_POST['password'])) : '';
$database = isset($_POST['database']) ? $mysqli->real_escape_string(trim($_POST['database'])) : '';

if (!empty($hostname) && !empty($username) && !empty($password) && !empty($database)) {
    $mysqli = new mysqli($hostname, $username, $password, $database);

    if ($mysqli->connect_error) {
        die("Connection failed: " . $mysqli->connect_error);
    } 
    echo "Connected successfully";
} else {
    echo "All the required data is not provided";
}

?>