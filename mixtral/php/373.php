<?php

$data = array(
    'name' => 'toasta'
);

$your_shared_secret = 'your_shared_secret_key_here'; // replace with your shared secret key

// Generate a secret key using HMAC-SHA256
$secret_key = hash_hmac('sha256', json_encode($data), $your_shared_secret, true);

// Convert the binary result to hexadecimal representation
$hash = bin2hex($secret_key);

$fields = array();
$fields['name'] = 'toasta';
$fields['hash'] = $hash;

print_r($fields);

?>