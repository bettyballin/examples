<?php

// Server side
if (!isset($_SERVER['HTTP_X_AUTHORIZATION']) || $_SERVER['HTTP_X_AUTHORIZATION'] !== 'your-secret-token') {
    header('HTTP/1.0 403 Forbidden');
    exit;
} else {
    echo "Authorized";
}

// Client side (mobile app)
$ch = curl_init();
curl_setopt($ch, CURLOPT_URL, "http://www.example.com");

# Set HTTP header for your authorization
curl_setopt($ch, CURLOPT_HTTPHEADER, array('X-Authorization: your-secret-token'));

$result = curl_exec($ch);
curl_close($ch);

echo $result;

?>