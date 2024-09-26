<?php
// Get POST data
$data = $_POST;

// Add your secret key
$secret_key = 'your-private-key';

if (!isset($data['mySecretKey'])) {
    $data['mySecretKey'] = $secret_key;
}

// Send the POST request to distant server

// Using cURL

$ch = curl_init('https://distantserver.com/endpoint');
curl_setopt($ch, CURLOPT_RETURNTRANSFER, true);
curl_setopt($ch, CURLOPT_POSTFIELDS, http_build_query($data));

// Execute the request
$response = curl_exec($ch);

if (curl_errno($ch)) {
    echo 'Error: "' . curl_error($ch) . '" - Code: ' . curl_errno($ch);
} else {
    // Show response
    echo $response;
}

// Close request
curl_close($ch);
?>