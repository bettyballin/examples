<?php

const IV_MESSAGE = "a";
const API_SECRET = "secret_key\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0";

function encrypt($stringData){
    $iv = substr(hash('sha256', IV_MESSAGE), 0, 16);
    $encrypted = openssl_encrypt($stringData, 'aes-256-cbc', API_SECRET, 0, $iv);
    return $encrypted;
};

$stringData = json_encode(array(
    "uid" => 19,
    "price" => 10000000,
    "duration" => 240,
    "credit_purpose" => 5,
    "new_tab" => false,
    "cssFile" => "kalkulatorok",
    "css" => array(),
    "supported" => false,
    "email" => "test@test.hu",
    "productType" => "home_loan",
    "method" => "calculator",
    "calculatorType" => "calculator",
    "unique" => true
));

$ciphertextB64 = base64_encode(encrypt($stringData));

echo chunk_split($ciphertextB64, 64);
?>