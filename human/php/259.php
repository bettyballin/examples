<?php
session_start();
$_SESSION['uid'] = 5;
$_SESSION['logged_on'] = true;
print_r($_SESSION);
?>