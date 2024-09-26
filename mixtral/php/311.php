<?php

function generateUuid() {
    return sprintf(
        '%04x%04x-%04x-%04x-%04x-%04x%04x%04x',
        mt_rand(0, 65535),
        mt_rand(0, 65535),
        mt_rand(0, 65535),
        mt_rand(0, 65535) & 0x0fff | 0x4000,
        mt_rand(0, 65535) & 0x3fff | 0x8000,
        bin2hex(random_bytes(6))
    );
}

echo generateUuid();

?>