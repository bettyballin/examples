<?php
$url = "http://localhost:8090/JSON/core/action/setOptionUserEnabled";

// Set API key
$apiKey = "<your_zap_apikey>";

// Prepare headers
$headers = [
    'Content-Type' => 'application/json'
];

if (!empty($apiKey)) {
  $headers['Authorization'] = "Bearer {$apiKey}";
}

// Set request body
$body = json_encode([
   "option"=>"API.disable",
    "enabled" => false
]);

// Send HTTP POST Request
$ch = curl_init();
curl_setopt($ch, CURLOPT_URL, $url);
curl_setopt($ch, CURLOPT_HTTPHEADER, array('Content-Type: application/json'));
curl_setopt($ch, CURLOPT_RETURNTRANSFER, true);

// Set request body
if (!empty($body)) {
  curl_setopt($ch, CURLOPT_POSTFIELDS, $body);
}

$response = json_decode(curl_exec($ch), true);

print_r($response);