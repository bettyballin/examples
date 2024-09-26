<?php
// Include library
include('Crypt/RSA.php');

// Create an Instance
$rsa  = new Crypt_RSA();

//Get Private Key
$privatekey = file_get_contents('C:\xampp\htdocs\encrypt\private.txt');
$rsa->loadKey($privatekey);

// Message to be signed
$plaintext = "<Transaction><No>1344</No></Transaction>";

// Hash the message
$hashed = hash('sha256', $plaintext);

$rsa->setSignatureMode(CRYPT_RSA_SIGNATURE_PKCS1); // Set signing signature 
$encrypted = $rsa->sign($hashed); // Sign Data
$signature = base64_encode($encrypted); // Encode to base64 the signed Data

echo $signature;
?>