
use phpseclib\Crypt\RSA;

$rsa = new RSA();

// Load the private key (assuming $privateKeyPem is the PEM-formatted private key)
$rsa->loadKey($privateKeyPem);

// Set the encryption mode
$rsa->setEncryptionMode
