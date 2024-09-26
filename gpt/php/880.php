
<?php
$key = 'someSecret'; // Your ASCII secret key
$time = '0000000002f3e3c9'; // Hex time

// Pack time into a binary string
$binaryTime = pack('H*', $time);

// Calculate HMAC hash with the SHA-1 algorithm
$hmac = hash_hmac
