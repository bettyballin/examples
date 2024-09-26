<?php

$key = unpack('C*', $rows[0]['sessionkey']);

function decipher($key, $data) {
    $decipher = openssl_decrypt($data, 'aes-256-cbc', implode(array_map("chr", $key)), OPENSSL_RAW_DATA | OPENSSL_NO_PADDING, str_repeat("\0", 16));
    return $decipher;
}

?>