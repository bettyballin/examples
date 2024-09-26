<?php
require_once 'CryptSharp.php';

$password = "password goes here";
$hash = "hash goes here";

$matches = Crypter::CheckPassword($password, $hash);
var_dump($matches);
?>