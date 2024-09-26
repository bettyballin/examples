<?php
$key_from_python = base64_decode('yxSWeywwKBWGINr4GyJpfE29xWTnpknff+ExruiKs2o=');

$ciphertext_nonce_from_python = base64_decode('Up/mRFxf3nhDgviOmzuRx09Mb8IJL49WPkc9x2bc4+QDPk2beZKd');

$ciphertext = substr($ciphertext_nonce_from_python, 16);
$nonce = substr($ciphertext_nonce_from_python, 0, 12);

$method = 'aes-256-ccm';
if (in_array($method, openssl_get_cipher_methods())) {
    $tagLength = 8;

    $plaintext = openssl_decrypt($ciphertext, $method, $key_from_python, OPENSSL_RAW_DATA, $nonce, NULL, $tagLength);
    echo $plaintext;
} else {
    echo "Cipher method not supported";
}
?>