<?php

$nonce = 'nonce';           // sample data
$secret = 'c2VjcmV0';       // sample data

$method = 'auth/register';
$param = [
    "email"                => 'test@test.com',
    "password"             => 'Password1234',
    "customerId"           => '1234',
];
$postdata = http_build_query($param, '', '&');
print('Postdata:  ' . $postdata . PHP_EOL);

$hash = '/' . $method . hash('sha256', $nonce . $postdata, true);
$signature = hash_hmac('sha512', $hash, base64_decode($secret), true);
$signature = base64_encode($signature);

print('Signature: ' . $signature . PHP_EOL);

?>