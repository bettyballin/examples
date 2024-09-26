<?php
include('config.php');
$con = mysqli_connect(DBHOST, DBUSER, DBPASS, DBNAME, DBPORT);

if (!$con) {
    die("Connection failed: " . mysqli_connect_error());
}
?>