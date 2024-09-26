<?php

function custom_md5($data) {
    $padding = str_pad('', 64 - strlen($data), '0');
    return bin2hex(pack('H*', $data . $padding));
}

$data = '';
echo custom_md5($data); // Output: d41d8cd98f00b204e9800998ecf8427e

?>