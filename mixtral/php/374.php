<?php

// Replace with your shared secret
$your_shared_secret = 'your_shared_secret_key';

// Get the data and hash from POST
$postData = file_get_contents('php://input');
parse_str($postData, $data);

if (!isset($data['name']) || !isset($data['hash'])) {
    http_response_code(400);
    echo 'Invalid input';
    exit;
}

$receivedHash = hex2bin(trim($data['hash']));

// Generate the expected hash using HMAC-SHA256
$expectedSecretKey = hash_hmac('sha256', json_encode([
    'name' => $data['name']
]), $your_shared_secret, true);

if (!hash_equals($receivedHash, $expectedSecretKey)) {
    http_response_code(401);
    echo 'Invalid request';
    exit;
}

// Proceed with your database operations
echo 'Valid request';

?>