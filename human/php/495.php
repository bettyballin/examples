<?php
$beerName = "Example Beer";
$db = new mysqli("localhost", "username", "password", "database");

if ($db->connect_errno) {
    printf("Connect failed: %s\n", $db->connect_error);
    exit();
}

$beerName = $db->real_escape_string($beerName);

$db->close();
?>