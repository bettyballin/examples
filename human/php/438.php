<?php

$publicKey = "MFwwDQYJKoZIhvcNAQEBBQADSwAwSAJBANDiE2+Xi/WnO+s120NiiJhNyIButVu6zxqlVzz0wy2j4kQVUC4ZRZD80IY+4wIiX2YxKBZKGnd2TtPkcJ/ljkUCAwEAAQ==";

$data = "For my current project I have to send a signature from PHP to Java application. I am using Crypt/RSA right now for signing my data.";
$signature = base64_decode("OnqiWnFQ2nAjOa1S57Du9jDpVr4Wp2nLdMk2FX+/qX1+SAHpVsW1JvQYqQUDlxvbTOE9vg6dlU6i3omR7KipLw==");

$pubKey = openssl_pkey_get_public("-----BEGIN PUBLIC KEY-----\n" . $publicKey . "\n-----END PUBLIC KEY-----");
$verified = openssl_verify($data, $signature, $pubKey, OPENSSL_ALGO_SHA256);

if ($verified === 1) {
    echo "Verified";
} elseif ($verified === 0) {
    echo "Not verified";
} else {
    echo "Error: " . openssl_error_string();
}
?>