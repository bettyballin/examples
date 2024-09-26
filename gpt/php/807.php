
<?php
// Always check for the availability of the libsodium extension
if (!extension_loaded('sodium')) {
    die('The Sodium extension is not available.');
}

// Generate a random key for encryption
$key = sodium_crypto_secretbox_keygen();

// The nonce should be unique for each message
$nonce = random_bytes(SODIUM_CRYPTO_SECRETBOX_NONCEBYTES);

// The message to encrypt
$message = 'This is a secret message.';

// Encrypt the message
$encrypted = sodium_crypto_secretbox($message, $nonce, $key);

// Now let's decrypt the message
