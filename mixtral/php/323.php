<?php

function encrypt($data, $key) {
    $iv = openssl_random_pseudo_bytes(openssl_cipher_iv_length('aes-256-cbc'));
    $encrypted = openssl_encrypt($data, 'aes-256-cbc', $key, 0, $iv);
    return base64_encode($iv . $encrypted);
}

function decrypt($data, $key) {
    $data = base64_decode($data);
    $iv = substr($data, 0, openssl_cipher_iv_length('aes-256-cbc'));
    $decrypted = openssl_decrypt(substr($data, openssl_cipher_iv_length('aes-256-cbc')), 'aes-256-cbc', $key, 0, $iv);
    return $decrypted;
}

$image = 'path_to_your_image.jpg';
$enc_image = encrypt(file_get_contents($image), "long secret random key");

// Store $enc_image in MySQL BLOB field

// Assume $rec is a row from your MySQL query
$decryptedImageData = decrypt($rec['file'], "long secret random key");

echo '<img src="data:image/*;base64,' . base64_encode($decryptedImageData) . '">';

?>