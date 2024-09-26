<?php
if (!isset($_COOKIE["login"]) || strlen($_COOKIE["login"]) <= 3) {
   header("Location: login.php");
   exit;
}
// user is valid
?>