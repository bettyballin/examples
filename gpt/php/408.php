
// ... previous code to set up $rsa and sign the plaintext ...

// Correctly encode the binary signature in Base64 to avoid data corruption
$encoded_sign = base64_encode($signature);
error_log("encoded sign for abc: " . $encoded_sign);

