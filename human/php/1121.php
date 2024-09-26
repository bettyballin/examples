<?php
$rsa = new phpseclib3\Crypt\RSA();
$rsa->setMGFHash('sha1');
$rsa->setHash('sha1');
?>