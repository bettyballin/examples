<?php
$url = 'http://example.com/file.php';
$ch = curl_init($url);
curl_setopt($ch, CURLOPT_RETURNTRANSFER, true);
$response = curl_exec($ch);
curl_close($ch);

$contents = $response;

print($contents);
?>