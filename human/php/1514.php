<?php

use MikeRow\Salt\NanoSalt;

$nanoSalt = new NanoSalt();
$public_key = $nanoSalt->crypto_sign_public_from_secret_key(hex2bin("781186FB9EF17DB6E3D1056550D9FAE5D5BBADA6A6BC370E4CBB938B1DC71DA3"));
print(strtoupper($public_key->toHex()) . PHP_EOL);