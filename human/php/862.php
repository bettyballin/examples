<?php

require_once 'vendor/autoload.php';
use Firebase\JWT\JWT;

$key = 'YOUR-SECURITY-KEY';
$token = array(
    'iss' => 'https://EXAMPLE.com',
    'iat' => time(),
    'd' => array(
        'foo' => 'bar'
    )
);
// Add additional data to token
$data = array(); // Define $data array
$token = array_merge($token, $data);
$jwt = JWT::encode($token, $key);

print($jwt);

?>