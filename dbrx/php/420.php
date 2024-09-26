<?php
require_once 'vendor/autoload.php';
use phpseclib3\Crypt\RSA;

$rsa = new RSA();
$keys = $rsa->createKey(2048);
$privatekey = $keys['privatekey'];
echo $privatekey;
?>