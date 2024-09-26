<?php
require_once __DIR__ . '/config.php';
session_start();

$dbh = new PDO('mysql:host=' . DB_HOST . ';dbname=' . DB_NAME, DB_USERNAME, DB_PASSWORD);

$sql  = "SELECT * FROM users WHERE username = :u";
$query = $dbh->prepare($sql); 
$params = array(":u" => $_POST['username']);
$query->execute($params); 

$results = $query->fetchAll(); 

if (count($results) > 0 && password_verify($_POST['password'], $results[0]['password'])) {
    $firstrow = $results[0];
    $_SESSION['username'] = $firstrow['username'];
    echo "Hello {$firstrow['username']} you have successfully logged in";
} else {
    echo "Login Has Failed. Please check your credentials and try again.";
}
?>