
define("ENCRYPTION_KEY", "QaY7e4d1c");

$string = "This is a text with diacritics: ěščřžýáíéúů";
echo $encrypted = encrypt($string, ENCRYPTION_KEY);
echo "\n";
echo $decrypted = decrypt($encrypted, ENCRYPTION_KEY);
echo "\n";

function encrypt($pure_string, $encryption_key)
{
    $ivLength = openssl_cipher_iv_length('aes-256-cbc');
    $iv =
