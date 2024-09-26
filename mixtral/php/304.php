<?php

$time = hex2bin("0000000002f3e3c9");
$secret = 'someSecret';

// Use hash_hmac with SHA-1 algorithm
$hmactext = hash_hmac('sha1', $time, $secret);

echo bin2hex($hmactext) . "\n";

?>