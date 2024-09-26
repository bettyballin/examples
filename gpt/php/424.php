
<?php
$key = "your-encryption-key";
$iv = "your-encryption-iv";
$message = "your-encryption-message";

// Open the cipher
$td = mcrypt_module_open('rijndael-128', '', 'cbc', $iv);

// Pad message to block size
$block = mcrypt_get_block_size('rijndael-128', 'cbc');
$pad = $block - (strlen($message) % $block);
$message .= str_repeat(chr($pad), $pad);

// Encrypt message
$
