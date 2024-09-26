
// Assuming $encrypted_text holds your encrypted data
// and $password is the password used for encryption
$decrypted_text = md5_decrypt($encrypted_text, $password);

// Output the decrypted text
echo $decrypted_text;

