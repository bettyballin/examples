<?php

$encryptedData = json_decode($_POST['data'], true);

$message = '';
// Convert JSON array into a binary string
foreach ($encryptedData as $byte) {
    // Append each byte to the encrypted message
    $message .= chr($byte);
}

$nonce = substr($message, 0, SODIUM_CRYPTO_SECRETBOX_NONCEBYTES);
$encodedEncryptedMessage = substr($message, SODIUM_CRYPTO_SECRETBOX_NONCEBYTES);
$key = 'your_secret_key_here'; // replace with your secret key

try {
  $decryptedMessage = sodium_crypto_secretbox_open(
      $encodedEncryptedMessage,
      $nonce,
      $key
  );
  if ($decryptedMessage !== false){
     // Decryption successful
    echo "Decrypted message: " . sodium_bin2hex($decryptedMessage);
  } else {
    throw new Exception("Invalid MAC");
  }
} catch (Exception $e) {
  die('Error decrypting data');
}

?>