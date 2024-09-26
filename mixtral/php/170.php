<?php
function db_connect($dbname){
    $server = 'localhost';
    $user   = getenv('DB_USER');
    $passwd = getenv('DB_PASSWORD');

    // Create connection
    $conn = new mysqli($server, $user, $passwd, $dbname);

    if ($conn->connect_error) {
        die("Connection failed: " . $conn->connect_error);
    }
    return $conn;
}
?>