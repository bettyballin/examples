<?php

function ctr_crypt($data, $key, $iv) {
    $cipher = 'aes-256-ctr';
    $decrypted = openssl_decrypt($data, $cipher, $key, OPENSSL_RAW_DATA | OPENSSL_ZERO_PADDING, $iv);
    return rtrim($decrypted, "\0");
}

$encrypted = base64_decode('MlNFlnXE1sqIsmKZRtjChBvUMgiJlXgdjHVxQJ6JK24Id4uaN9NK/nBtY+cgrMJR/PRJRCmIUx0boQO5XqJYZ8VJ0w==');
$key = base64_decode('HB+dD1Irj2rXQ/nO+IuqSiK9xVE3PD9cZGIGzrMtwtA=');
$iv = base64_decode('2gxxKYU/G4lj7174e5wj+g==');

var_dump(ctr_crypt($encrypted, $key, $iv));