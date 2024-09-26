
$config = array(
    "digest_alg" => "sha512",
    "private_key_bits" => 4096,
    "private_key_type" => OPENSSL_KEYTYPE_RSA,
);

// Create the private and public key
$res = openssl_pkey_new($config);

// Extract the private key
openssl_pkey_export($res, $privateKey);

// Extract the public key
$publicKey = openssl_pkey_get_details($res);
$publicKey = $publicKey["key"];

file_put_contents('private_key.pem', $privateKey);
file_put_contents('public_key.pem', $publicKey);

