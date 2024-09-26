<?php
require 'vendor/autoload.php';
use Bcrypt\Bcrypt;

$bcrypt = new Bcrypt();
$salt = $bcrypt->genSalt(20);
$hash = $bcrypt->hash($userId, $salt);
return $hash;