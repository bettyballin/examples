<?php

function encrypt($key, $data) {
    return hash_hmac('sha256', $data, $key);
}

function getPKey() {
    return 'your_secret_key_here'; // replace with your secret key
}

function getToken($timestamp) {
    return $timestamp . encrypt(getPKey(), $timestamp);
}

function genToken($timestamp) {
    return getToken($timestamp);
}

$token = genToken(time());
print($token);

?>