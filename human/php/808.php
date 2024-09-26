<?php
// Set the password
$password = 'mypassword';

// Get the hash, letting the salt be automatically generated
$hash = crypt($password);

echo $hash; // for testing purposes only

$mysql_username = 'username'; // for DB
$mysql_password = 'password'; // for DB

$dbh = new PDO('mysql:host=localhost;dbname=database_name', $mysql_username, $mysql_password);

$stmt = $dbh->prepare("INSERT INTO table_name (name,pass) VALUES (:name,:pass)");
$stmt->bindParam(':name', $name);
$stmt->bindParam(':pass', $pass);

// insert rows
// $name = $_POST['name'];
// $name = $_POST['pass'];

$name = "username";
$pass = $hash;
$stmt->execute();

$dbh = null;
?>