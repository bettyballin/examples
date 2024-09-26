<?php
$url = 'http://example.com'; // replace with your URL

$ch = curl_init($url);
curl_setopt($ch, CURLOPT_COOKIEJAR, '/tmp/cookie.txt'); 
curl_setopt($ch, CURLOPT_RETURNTRANSFER, true);
curl_setopt($ch, CURLOPT_FOLLOWLOCATION, true);
$content = curl_exec ($ch);
curl_close ($ch);

print_r($content);
?>