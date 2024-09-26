<?php
session_start();
$_SESSION['submitted'] = 'somevalue';
print_r($_SESSION);
?>