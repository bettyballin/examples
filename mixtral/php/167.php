<?php

function php_enc($iv, $key, $plaintext) {
  $td = mcrypt_module_open(MCRYPT_RIJNDAEL_128, '', MCRYPT_MODE_CBC, '');

  // Add pkcs #7 Padding
  $block = mcrypt_get_block_size(MCRYPT_RIJNDAEL_128, MCRYPT_MODE_CBC);

  if (($pad = $block - (strlen($plaintext) % $block)) < $block) {
    for ($i = 0; $i < $pad; $i++) {
      $plaintext .= chr($pad);
    }
  }

  mcrypt_generic_init($td, $key, $iv);

  // Encryption
  $ciphertext = mcrypt_generic($td, $plaintext);

  mcrypt_generic_deinit($td);
  mcrypt_module_close($td);

  return base64_encode($ciphertext);
}

// Example usage:
$iv = 'your_iv_here';
$key = 'your_key_here';
$plaintext = 'your_plaintext_here';

echo php_enc($iv, $key, $plaintext);

?>