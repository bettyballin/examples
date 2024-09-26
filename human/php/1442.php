<?php
$headers = array(
    ':authority' => 'example.com',
    ':method' => 'GET',
    ':path' => '/account',
    ':scheme' => 'https',
    'accept' => 'text/html,application/xhtml+xml,application/xml;q=0.9,image/webp,image/apng,*/*;q=0.8',
    'accept-encoding' => 'gzip, deflate, br',
    'accept-language' => 'en-US,en;q=0.9',
    'cache-control' => 'max-age=0',
    'dnt' => '1',
    'upgrade-insecure-requests' => '1',
);

$ch = curl_init('https://example.com/account');
curl_setopt($ch, CURLOPT_RETURNTRANSFER, true);
curl_setopt($ch, CURLOPT_HTTPHEADER, $headers);
$response = curl_exec($ch);
curl_close($ch);

print($response);
?>