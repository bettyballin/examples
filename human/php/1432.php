<?php
// Data from Python code
$key_from_python = base64_decode('your_base64_encoded_key_from_python');
$ciphertext_from_python = base64_decode('your_base64_encoded_ciphertext_tag_from_python');
$nonce_from_python = base64_decode('your_base64_encoded_nonce_from_python');
$cipher = 'aes-256-ccm';

// Separate ciphertext and tag
$tagLength = 8;
$ciphertext = substr($ciphertext_from_python, 0, -$tagLength);
$tag = substr($ciphertext_from_python, -$tagLength);

// Decrypt
if (in_array($cipher, openssl_get_cipher_methods())){
    $decrypted_mesage_from_pythom = openssl_decrypt($ciphertext, $cipher, $key_from_python, OPENSSL_RAW_DATA, $nonce_from_python, $tag);
    echo $decrypted_mesage_from_pythom;
}
?>