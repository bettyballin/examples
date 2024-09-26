
// Use 32 for the length to get 16 bytes of the hash
$hash = hash_pbkdf2('sha1', 'testing123', $salt, 3000, 32);

