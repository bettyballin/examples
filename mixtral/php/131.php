<?php

$iv = mcrypt_create_iv(mcrypt_get_iv_size(MCRYPT_RIJNDAEL_128, MCRYPT_MODE_CBC), MCRYPT_RAND);
$td = mcrypt_module_open(MCRYPT_RIJNDAEL_128, '', MCRYPT_MODE_CBC, '');

// Your $this->secret and $data variables should be defined here
$secret = 'your_secret_key';
$data = 'your_data_to_encrypt';

mcrypt_generic_init($td, $secret, $iv);
$encryptedData = $secret . '::' . base64_encode($iv) . ':' . base64_encode(mcrypt_generic($td, $data));
mcrypt_generic_deinit($td);
mcrypt_module_close($td);

echo $encryptedData;

?>