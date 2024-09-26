
$key = 'test';
$input = 'test';

// Create an initialization vector (IV) from a random source
$iv_size = mcrypt_get_iv_size(MCRYPT_CAST_256, MCRYPT_MODE_CBC);
$iv = mcrypt_create_iv($iv_size, MCRYPT_RAND);

// Encrypt the input
$encrypted = mcrypt_encrypt(M
