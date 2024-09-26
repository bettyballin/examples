<?php
require 'vendor/autoload.php';
use Cake\Utility\Security;

$token = Security::generateToken(128);
print($token);
?>