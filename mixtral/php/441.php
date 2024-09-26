<?php

$privateKey = random_bytes(SODIUM_CRYPTO_SIGN_SECRETKEYBYTES);

// Generate the public key
$publicKey = sodium_crypto_sign_publickey($privateKey);

// Hash the public key using Blake2b-40
$checksum = hash('blake2b', $publicKey, true);

print($checksum);

?>