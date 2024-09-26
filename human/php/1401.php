<?php

$url = 'http://169.254.169.254/metadata/identity/oauth2/token';
$params = [
    'api-version' => '2018-02-01',
    'resource' => 'https://storage.azure.com/'
];

$headers = [
    'Metadata: true'
];

$ch = curl_init($url);
curl_setopt($ch, CURLOPT_RETURNTRANSFER, true);
curl_setopt($ch, CURLOPT_HEADER, true);
curl_setopt($ch, CURLOPT_HTTPHEADER, $headers);
curl_setopt($ch, CURLOPT_POSTFIELDS, http_build_query($params));
curl_setopt($ch, CURLOPT_CUSTOMREQUEST, 'GET');

$response = curl_exec($ch);
curl_close($ch);

print_r($response);

?>