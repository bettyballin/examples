<?php

function decrypt_aes_gcm($encrypted, $salt, $iv, $password) {
  $encrypted = base64_decode($encrypted);
  $salt = base64_decode($salt);
  $iv = base64_decode($iv);
  $key = hash_pbkdf2('sha256', $password, $salt, 1000, 256/8, true);
  $tag = substr($encrypted, -16, 16);
  $encrypted = substr($encrypted, 0, -16);
  return openssl_decrypt($encrypted, 'aes-256-gcm', $key, OPENSSL_RAW_DATA, $iv, $tag);
}

// Example usage
$encrypted = 'your_encrypted_data';
$salt = 'your_salt';
$iv = 'your_iv';
$password = 'your_password';

$decrypted = decrypt_aes_gcm($encrypted, $salt, $iv, $password);
echo $decrypted;

?>