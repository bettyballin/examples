<?php
require_once 'vendor/autoload.php';
use Firebase\JWT\JWT;

$string_JSONWebToken = "your_jwt_token_here";
$array_publicKeysWithKIDasArrayKey = array(
    "kid1" => "public_key1",
    "kid2" => "public_key2"
);

try {
    $decoded = JWT::decode($string_JSONWebToken, $array_publicKeysWithKIDasArrayKey, array('RS256'));
    print_r($decoded);
} catch (Exception $e) {
    echo 'Caught exception: ',  $e->getMessage(), "\n";
}
?>