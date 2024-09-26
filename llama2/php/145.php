<?php
require_once 'vendor/autoload.php';
use Phpseclib3\Crypt\AES;

$xml = <<<EOF
<root>
    <user>John</user>
    <password>Doe123</password>
</root>
EOF;

$key = 'my_secret_key';

$cipher = new AES($key);
$cipher->setMode(AES::MODE_ECB);
$encrypted_data = $cipher->encrypt($xml);

echo $encrypted_data;
?>