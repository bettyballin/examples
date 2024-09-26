<?php

$url = 'https://example.com/image.jpg';

$ch = curl_init();
curl_setopt($ch, CURLOPT_URL, $url);
curl_setopt($ch, CURLOPT_RETURNTRANSFER, 1);

$response = curl_exec($ch);
curl_close($ch);

$imageData = getimagesizefromstring($response);

if ($imageData !== false) {
    echo 'OK';
} else {
    echo 'Error: Unable to fetch image data.';
}

?>