
<?php
// Your public key
$publicKey = openssl_pkey_get_public('file://path/to/public.pem');

// Data to encrypt
$data = "This is a secret message.";

// Encrypt the data using openssl_seal
if (openssl_seal($data, $sealed_data, $ekeys, array($publicKey))) {
    // $sealed_data is now encrypted
    // $ekeys will contain the encrypted key for the recipient

    // Encode the sealed data and envelope key in base64 to output as a string
    $sealed_data_base64 = base64_encode($sealed_data);
    $ekey_base64 = base64_encode($ekeys[0]);
} else {
    // Handle encryption error
