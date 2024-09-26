<?php

function getPasswordHash($test) {
    // Generate nonce
    $nonce = $test ? '55d61876-f882-42f0-b390-dc662a7e7279' : bin2hex(random_bytes(16));
    echo 'nonce (Base64):  ' . base64_encode($nonce) . "\n";

    // Generate created
    $created = $test ? '2021-01-21T18:19:32Z' : gmdate('Y-m-d\TH:i:s\Z');
    echo 'created:         ' . $created . "\n";

    // Hash password
    $pwd = 'SECRETPASSWORD';
    $pwdHash = hash('sha1', $pwd, true);

    // Hash nonce + created + pwd
    $passwordHash = base64_encode(hash('sha1', $nonce . $created . $pwdHash, true));

    echo 'passwordHash:    ' . $passwordHash . "\n";
}

getPasswordHash(true);    // with testdata
getPasswordHash(false);   // without testdata

?>