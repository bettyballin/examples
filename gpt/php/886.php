
function decrypt($key, $data) {
    // Ensure the key is 24 bytes long, as 3DES requires
    $key = substr($key, 0, 24); // Truncate to 24 bytes if it's longer

    // Decode data from base64
    $data = base64_decode($data);

    // Open the cipher module and create an IV
    $mcrypt_module = mcrypt_module_open(MCRYPT_TRIPLEDES, '', MCRYPT_MODE_ECB, '');
    $mcrypt_iv     = mcrypt_create_iv(mcrypt_enc_get_iv_size
