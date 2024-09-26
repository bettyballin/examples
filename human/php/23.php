<?php
$string = $_POST['searchTerm'];
if (get_magic_quotes_gpc()) {
    $string = stripslashes($string);
}
$string = str_replace("%", "", $string);
$mysqli = new mysqli("localhost", "username", "password", "database");
$safeString = $mysqli->real_escape_string($string);
?>