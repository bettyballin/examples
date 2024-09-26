<?php

$url = 'http://api.local/api/1.0/resource/action';
$timestamp = 1574268077;
$secret_key = 'your_secret_key_here';
$signature = hash_hmac('sha256', $timestamp . "\n" . '/api/1.0/resource/action', $secret_key);
$auth_header = 'hmac ' . $timestamp . '.' . $signature;

$headers = [
    'Content-Type: application/json',
    'Authorization: ' . $auth_header,
    'Host: api.local'
];

$payload = json_encode(['some' => 'payload']);

$ch = curl_init($url);
curl_setopt($ch, CURLOPT_RETURNTRANSFER, true);
curl_setopt($ch, CURLOPT_POST, true);
curl_setopt($ch, CURLOPT_POSTFIELDS, $payload);
curl_setopt($ch, CURLOPT_HTTPHEADER, $headers);

$response = curl_exec($ch);

curl_close($ch);

print($response);

?>