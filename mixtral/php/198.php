<?php
// Configuration
define('DB_HOST', 'your_host');
define('DB_USERNAME', 'your_username');
define('DB_PASSWORD', 'your_password');
define('DB_NAME', 'your_database');

// Connection
$dbh = new PDO('mysql:host=' . DB_HOST . ';dbname=' . DB_NAME, DB_USERNAME, DB_PASSWORD);

// Hash the user's inputted password
$hashedPassword = password_hash($_POST["password"], PASSWORD_DEFAULT);

$username = $_POST['username'];
$email    = $_POST['email'];

// Use prepared statements for SQL queries
$stmt     = $dbh->prepare("INSERT INTO users (username, email, password) VALUES(:u, :e, :p)");

$params   = array(
  ":u" => $username,
  ":e" => $email,
  ":p" => $hashedPassword
);

$stmt->execute($params);

// Close the connection
$dbh = null;
?>