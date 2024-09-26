<?php
$random = '87fd...'; // your random bytes as string

// create and initialize hash object using $random as input data
$context = hash_init('md5', HASH_HMAC, hex2bin($random));

// update the context with secret data (e.g. "ABCDEF-G...")
hash_update($context, 'ABCDEF-G...');

// compute final message digest based on updated state
$result = hash_final($context);

echo $result; // should match CryptoAPI output for same inputs
?>