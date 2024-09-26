<?php

require_once 'path/to/your/NaNosalt.php';

use MikeRow\Salts\NanoSalt;

$publicKey = NanoSalt::cryptoSignPublicFromSecretKey(hex2bin("781186FB9EF17DB6E3D1056550D9FAE5D5BBADA6A6BC370E4CBB938B1DC71DA3"));
print(strtoupper($publicKey->toHex()) . PHP_EOL);

?>