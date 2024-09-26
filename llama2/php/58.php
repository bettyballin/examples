<?php
$secretKey = 'your_long_random_string';
$requestParams = http_build_query(array('id' => 1234));
$hash = hash_hmac('sha256', $requestParams, $secretKey);
echo $hash;
?>