
<?php
$data = "Sensitive data to be encrypted";
$key = 'encryption_key'; // Should be properly generated and stored securely
$iv = openssl_random_pseudo_bytes(openssl_cipher_iv_length('aes-256-cbc'));

$encryptedData = openssl_encrypt($data, 'aes-256-cbc', $key, 0, $iv);
$encryptedDataWithIv = base64_encode($iv . $encryptedData);
// Now insert $encryptedDataWithIv into your XML structure
?>

