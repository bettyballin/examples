<?php

use phpseclib3\Crypt\DSA;
use phpseclib3\File\X509;

$dsa = new DSA(1024);
$dsaKey = $dsa->getKey();

$pem = new X509();
$pem->setPrivateKey($dsaKey);
$pem->setPublicKey($dsaKey);

file_put_contents("dsa.pem", $pem->saveX509($pem->currentCert));

?>