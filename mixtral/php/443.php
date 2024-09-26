<?php
session_start();
$uuid = uniqid(true);
setcookie("LAX_SESSION", $uuid, 0, "/", "example.com");
$_SESSION["temp"][$uuid] = $_SESSION;
// Redirect to payment service
header("Location: https://paymentservice/...");
exit;
?>