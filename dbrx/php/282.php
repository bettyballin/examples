<?php
$uuid = sprintf('%04x%04x-%04x-%04x-%04x-%04x%04x%04x',
    mt_rand(0, 65535), mt_rand(0, 65535), // 32 bits for "time_low"
    mt_rand(0, 65535), // 16 bits for "time_mid"
    mt_rand(0, 65535), // 16 bits for "time_hi_and_version" // four most significant bits holds version number 4
    mt_rand(16384, 20479), // 12 bits before the dash // two least significant ones of which are reserved
    mt_rand(0, 4095) + 32768, // 48 bits for "clock_seq_and_node"
    mt_rand(0, 65535), mt_rand(0, 16777215)
);
print($uuid);
?>