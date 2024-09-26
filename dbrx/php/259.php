<?php
session_start();
$uniqueCode = bin2hex(openssl_random_pseudo_bytes(16));
$_SESSION['unique_code'] = $uniqueCode;
print_r($_SESSION);
?>