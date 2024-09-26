<?php

require_once '/path/to/includes/config.php';

// Your existing code here...

$connection = new mysqli($servername, $username, $password, $dbname);

if ($connection->connect_error) {
    die("Connection failed: " . $connection->connect_error);
}

// Rest of the query and export logic...

$connection->close();

?>