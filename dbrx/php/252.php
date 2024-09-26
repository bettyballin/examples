$publicKey = file_get_contents('path/to/public.pem');
$data = 'your data here'; // data that was signed
$signature = 'your signature here'; // signature to verify

$result = openssl_verify($data, $signature, $publicKey, OPENSSL_ALGO_SHA256);
if ($result === 1) {
    // Signature is valid.
} else if ($result === 0) {
    // Invalid signature or error occurred during verification.
} else {
    // An error occurred.
    echo openssl_error_string();
}