
<?php
function encryptFile($sourceFile, $destFile, $passphrase) {
    // Generate a secure IV using openssl_random_pseudo_bytes
    $ivLength = openssl_cipher_iv_length('aes-256-cbc');
    $iv = openssl_random_pseudo_bytes($ivLength);

    // Read the plaintext
    $plaintext = file_get_contents($sourceFile);
    if ($plaintext === false) {
        throw new Exception("Could not read the source file");
    }

    // Encrypt the plaintext
    $ciphertext = openssl_encrypt($plaintext, 'aes-256-cbc', $passphrase, OPENSSL_RAW_DATA, $iv);
    if ($ciphertext === false) {
        throw new Exception("Could not encrypt the data");
    }

    // Prepend the IV for it to be available for decryption
    $ciphertextWithIv = $iv . $ciphertext;

    // Write the encrypted data to the destination
