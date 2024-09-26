<?php
$url = 'http://example.com'; // replace with your URL
$post = 'field1=value1&field2=value2'; // replace with your POST data

$ch = curl_init($url);
curl_setopt($ch, CURLOPT_POSTFIELDS, $post);
curl_setopt($ch, CURLOPT_COOKIEFILE, '/tmp/cookie.txt');
curl_setopt($ch, CURLOPT_COOKIEJAR, '/tmp/cookie.txt');  
curl_setopt($ch, CURLOPT_RETURNTRANSFER, true);
curl_setopt($ch, CURLOPT_FOLLOWLOCATION, true);
$content = curl_exec ($ch);
curl_close ($ch);

print $content;
?>