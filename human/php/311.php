<?php
$url = 'http://example.com'; // replace with your URL
$username = 'your_username'; // replace with your username
$password = 'your_password'; // replace with your password

$ch = curl_init($url);
curl_setopt($ch, CURLOPT_RETURNTRANSFER, TRUE);
curl_setopt($ch, CURLOPT_USERPWD, $username . ':' . $password);
curl_setopt($ch, CURLOPT_HTTPAUTH, CURLAUTH_ANY);
$output = curl_exec($ch);
$info = curl_getinfo($ch);
curl_close($ch);

print_r($output);
print_r($info);
?>