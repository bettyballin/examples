<?php

$Data = './datas';
$Envkey = './envkey';
$PrivateKey = './privkey';

function b64Dec($input) {
    return base64_decode($input);
}

function hxDump($input) {
    return bin2hex($input);
}

function rsaDec($privateKey, $input) {
    openssl_private_decrypt($input, $decrypted, $privateKey);
    return $decrypted;
}

function rc4Dec($key, $input) {
    $decrypted = '';
    $rc4 = mcrypt_module_open('rc4', '', 'ecb', '');
    mcrypt_generic_init($rc4, $key, '');
    $decrypted = mdecrypt_generic($rc4, $input);
    mcrypt_generic_deinit($rc4);
    mcrypt_module_close($rc4);
    return $decrypted;
}

function rc4Enc($key, $input) {
    $encrypted = '';
    $rc4 = mcrypt_module_open('rc4', '', 'ecb', '');
    mcrypt_generic_init($rc4, $key, '');
    $encrypted = mcrypt_generic($rc4, $input);
    mcrypt_generic_deinit($rc4);
    mcrypt_module_close($rc4);
    return $encrypted;
}

$key = hxDump(rsaDec($PrivateKey, b64Dec(file_get_contents($Envkey))));

$decryptedData = rc4Dec($key, b64Dec(file_get_contents($Data)));
echo $decryptedData . "\n";

$georgeOrwellQuote = "In our age there is no such thing as 'keeping out of politics.' All issues are political issues, and politics itself is a mass of lies, evasions, folly, hatred and schizophrenia. -- George Orwell --";
$encryptedQuote = base64_encode(rc4Enc($key, $georgeOrwellQuote));
echo $encryptedQuote . "\n";

?>