
<?php
// $prvKeyBytes should be the DSA private key in PEM format
$prvKeyBytes = '-----BEGIN PRIVATE KEY-----
...
-----END PRIVATE KEY-----';

// $data is the content you want to sign
$data = 'The quick brown fox jumps over the lazy dog';

// Load the private key
$pkeyid = openssl_pkey_get_private($prvKeyBytes);

// Compute the signature
$signature = '';
openssl_sign($data, $signature, $pkeyid, OPENSSL_ALGO_SHA1);

// Free the key from memory
openssl_free_key($pkeyid);

// $signature is now a binary string with the DSA signature
// You can use bin2hex() if you need the signature in hexadecimal format
$signature_hex = bin2hex($signature);

echo $signature_hex;
?>

