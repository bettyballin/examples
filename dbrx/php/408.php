<?php

use MikeRow\NanoPHP\NanoTool;
use MikeRow\Salt\NanoSalt;

require_once 'vendor/autoload.php';

$private_key = hex2bin('781186FB9EF17DB6E3D1056550D9FAE5D5BBADA6A6BC370E4CBB938B1DC71DA3');
$nano_salt   = new NanoSalt();
$public_key  = $nano_salt->crypto_sign_public_from_secret_key($private_key);
$checksum    = substr(NanoTool::addressFromPublickey($public_key), -8);

echo strtoupper(bin2hex($private_key)) . PHP_EOL;
echo strtoupper($public_key->toHex())   . PHP_EOL;
echo $checksum                          . PHP_EOL;

?>