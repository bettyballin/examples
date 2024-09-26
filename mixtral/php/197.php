<?php
require_once __DIR__ . '/config.php';
session_start();

$dbh = new PDO('mysql:host=' . DB_HOST . ';dbname=' . DB_NAME, DB_USERNAME, DB_PASSWORD);

// Fetch the user with matching username
$sql = "SELECT * FROM users WHERE username = :u";
$query = $dbh->prepare($sql);
$params = array(":u" => $_POST['username']);
$query->execute($params);

$results = $query->fetchAll();

if (count($results) > 0 ) {
    // Verify the password
    if(password_verify($_POST["password"], $results[0]['password'])){
        $_SESSION['username'] = $results[0]['username'];
        echo "Hello {$results[0]['username']} you have successfully logged in";

        header("location:index.php");
        exit;

    } else {
      // Password is incorrect
       echo 'Login has failed';

   return;
  }

}
?>