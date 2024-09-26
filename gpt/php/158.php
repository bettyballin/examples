
// Gives me my random key. My salt generator.
$salt = uniqid(mt_rand(), true);

// My password via what users inputs.
$userpwd = $_POST['password'];

// Then the encryption. I use a HMAC hash.
$encrypted = hash_hmac("sha256", $userpwd, $salt);

// Store $encrypted and $salt in the database for the user

