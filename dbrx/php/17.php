<?php
function authenticateUser($uName, $pass, $link) {
    // Replace this with your actual authentication logic
    // For demonstration purposes, I'm assuming a simple database query
    $query = "SELECT * FROM users WHERE username = '$uName' AND password = '$pass'";
    $result = mysqli_query($link, $query);
    return mysqli_num_rows($result) > 0;
}

// Establish database connection
$link = mysqli_connect("localhost", "username", "password", "database");

// Check connection
if (!$link) {
    die("Connection failed: " . mysqli_connect_error());
}

$uName = 'your_username';
$pass = 'your_password';

if (authenticateUser($uName, $pass, $link)) {
    echo 'Log in successful!';
} else {
    echo 'Authentication failed.';
}

mysqli_close($link);
?>