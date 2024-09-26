
<?php

require 'vendor/autoload.php';

use phpseclib3\Crypt\PublicKeyLoader;
use phpseclib3\Crypt\RSA;

// Generate a new private key
$privateKey = RSA::createKey(2048);

// Extract the public key
$publicKey = $privateKey->getPublicKey();

