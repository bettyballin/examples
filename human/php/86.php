<?php
$ip = $_SERVER['REMOTE_ADDR'];
$minutes = 30; // replace with desired minutes
$query = "INSERT INTO brute_force (ip, action, expires)
VALUES ('$ip', 'passwordReset', NOW() + INTERVAL $minutes MINUTE)";
mysqli_query($conn, $query);
?>