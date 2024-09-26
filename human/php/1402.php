<?php

$url = 'https://myaccount.blob.core.windows.net/mycontainer/myblob';
$headers = array(
    'x-ms-version: 2019-02-02',
    'Authorization: Bearer <access_token>'
);

$ch = curl_init($url);
curl_setopt($ch, CURLOPT_RETURNTRANSFER, true);
curl_setopt($ch, CURLOPT_HEADER, true);
curl_setopt($ch, CURLOPT_HTTPHEADER, $headers);

$response = curl_exec($ch);
curl_close($ch);

print($response);

?>