<?php

// set up the standard database

// Connection codes:
$host = "localhost";
$user = "imauser";
$password = "imapassword";
$testMode = true; // or false

//use a ternary like this
$dbname = $testMode ? 'testDB' : 'liveDB';

$cxn = mysqli_connect($host, $user, $password, $dbname) or die("Couldn't connect to the server: " . mysqli_connect_errno());

?>