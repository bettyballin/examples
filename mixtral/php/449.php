<?php

// Generate keypair
$keypair = sodium_crypto_sign_keypair();

// Extract public & secret (private) keys
list($publicKey, $secretKey) = array(
    base64_encode(sodium_crypto_sign_publickey($keypair)),
    base64_encode(sodium_crypto_sign_secretkey($keypair))
);

print "Public Key: $publicKey\n";
print "Secret Key: $secretKey\n";

?>