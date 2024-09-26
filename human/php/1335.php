<?php

$url = 'your_url_here';

$ch = curl_init($url);

curl_setopt($ch, CURLOPT_RETURNTRANSFER, true);
curl_setopt($ch, CURLOPT_HEADER, true);
curl_setopt($ch, CURLOPT_HTTPHEADER, array('Cookie: ' . $_SERVER['HTTP_COOKIE']));

$response = curl_exec($ch);

curl_close($ch);

if ($response !== false) {
    echo $response;
} else {
    echo 'An error occurred: ' . curl_error($ch);
}

?>