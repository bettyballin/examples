<?php

function read_iv($fromf, $size) {
    // implementation of read_iv function
    return 'your_iv_string';
}

$td = mcrypt_module_open(MCRYPT_RIJNDAEL_256, '', MCRYPT_MODE_CBC, '');
$mode = MCRYPT_MODE_CBC;
$noiv = 0;

if (mcrypt_generic_init($td, 'your_key_string', 'your_iv_string') < 0) {
    exit(1);
}

if (mcrypt_enc_self_test($td) < 0) {
    exit(1);
}

if (mcrypt_enc_is_block_mode($td) != 0) {
    if (mcrypt_enc_get_block_size($td) <= 1) {
        exit(1);
    }
}

if (mcrypt_enc_is_block_mode($td) != 0 && mcrypt_enc_get_block_size($td) != 1) {
    $blocksize = mcrypt_enc_get_block_size($td);
} else {
    $blocksize = 1;
}

$iv_size = mcrypt_enc_get_iv_size($td);

if (mcrypt_enc_mode_has_iv($td, $mode) != 0) {
    $IV = read_iv('FROMF', $iv_size);
} else {
    $IV = str_repeat("\0", $iv_size);
}

mcrypt_generic_deinit($td);
mcrypt_module_close($td);

?>