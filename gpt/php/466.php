
$ciphertext = base64_decode("zA/eeF+WFVMDsZ7+iA==");

// Ensure you have the correct size for the IV, which should be 16 bytes for AES.
$iv = substr($ciphertext, 0, 16);
$text = substr($ciphertext, 16);

$td = mcrypt_module_open(MCRYPT_RIJNDAEL_128, "",
