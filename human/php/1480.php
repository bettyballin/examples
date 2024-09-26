<?php

function CalculateSignature($method, $nonce, $postdata, $secret) {
    $signature = hash_hmac('sha256', $method . $nonce . $postdata, base64_decode($secret), true);
    return base64_encode($signature);
}

$method = "auth/register";
$nonce = "nonce";
$postdata = "email=test%40test.com&password=Password1234&customerId=1234";
$secret = "c2VjcmV0";

$signatureB64 = CalculateSignature($method, $nonce, $postdata, $secret);

echo $signatureB64;

?>