<?php

$IV = hex2bin("01000000000000000000000000000000");
$c = array(
    hex2bin("707612584E381CE192CA34FB9A37C50A"),
    hex2bin("75F20B46A1DF5660D45C764B5219DA83")
);

print($IV . "\n");
print($c[0] . "\n");
print($c[1] . "\n");

function hex2bin($hex) {
    return pack('H*', $hex);
}
?>