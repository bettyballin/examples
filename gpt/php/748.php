
$data = "The data you want to sign";

// Load the private key from a file or a secure location
$privateKey = openssl_pkey_get_private('file://path/to/private_key.pem');

// Sign the data
openssl_sign($data, $signature, $privateKey, OPENSSL_ALGO_SHA256);

// Ensure you free the private key from memory
openssl_free_key($privateKey);

// The signature is now stored in $signature, and you can send it along with your data

