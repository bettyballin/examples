<?php

$headers = array(
    'Accept: text/html,application/xhtml+xml,application/xml;q=0.9,image/webp,image/apng,*/*;q=0.8',
    'Accept-Encoding: gzip, deflate',
    'Accept-Language: en-US,en;q=0.9',
    'Cache-Control: max-age=0',
    'Connection: keep-alive',
    'DNT: 1',
    'Host: subdomain.example.com',
    'If-Modified-Since: Wed, 27 May 2020 20:51:35 GMT',
    'If-None-Match: "6c5-5a6a760afe782-gzip"',
    'Upgrade-Insecure-Requests: 1',
    'User-Agent: [redacted]'
);

$ch = curl_init('http://subdomain.example.com');
curl_setopt($ch, CURLOPT_RETURNTRANSFER, true);
curl_setopt($ch, CURLOPT_HTTPHEADER, $headers);
$response = curl_exec($ch);
curl_close($ch);

echo $response;

?>