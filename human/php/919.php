<?php

$db_host = "localhost";
$db_user = "username";
$db_pass = "password";
$db_database = "database_name";

$conn = mysqli_connect($db_host, $db_user, $db_pass, $db_database);

if (!$conn) {
    die("Connection failed: " . mysqli_connect_error());
}

echo "Connected successfully";

mysqli_close($conn);

?>