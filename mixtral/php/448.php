<?php
$privateKey = base64_decode('YOUR_PRIVATE_KEY');
$data = 'Hello World!';

$message = $data;
$signature = '';

if (sodium_crypto_sign($message, $signature, $privateKey)) {
    echo "Signature: " . bin2hex($signature) . "\n";
} else {
    throw new Exception('Failed to sign');
}
?>