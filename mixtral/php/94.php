<?php
$connect = mysqli_connect("localhost", "username", "password", "database");

$stmt = $connect->prepare("INSERT INTO users(username) VALUES (?)");

if ($stmt === false) {
    die('Error preparing statement');
}

// Bind parameters
$bindResult = mysqli_stmt_bind_param($stmt, 's', $_POST['username']);

if ($bindResult !== true) {
    die("Unable to bind parameter");
}

// Execute the query
mysqli_stmt_execute($stmt);

// Close the statement and connection
mysqli_stmt_close($stmt);
mysqli_close($connect);
?>