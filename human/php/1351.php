<?php
$fp = fopen("private.pem", "r");
$privateKey = fread($fp, 8192);
fclose($fp);

$cipher = 'your_base64_encoded_cipher_text'; // replace with your cipher text

$res = openssl_get_privatekey($privateKey);
$cipher = base64_decode($cipher);
openssl_private_decrypt( $cipher, $decrypted, $res, OPENSSL_PKCS1_OAEP_PADDING );

echo $decrypted;
?>