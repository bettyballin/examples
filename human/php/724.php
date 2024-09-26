<?php
session_start();
$_SESSION['_agent'] = sha1($_SERVER['HTTP_USER_AGENT']);
print_r($_SESSION);
?>