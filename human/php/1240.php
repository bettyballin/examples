<?php
$mysqli = new mysqli("localhost", "username", "password", "database");

$query = "SELECT * FROM table";

// Procedural style
mysqli_query($mysqli, $query);

// Object-oriented style
$mysqli->query($query);
?>