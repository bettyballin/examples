<?php

$c1 = '75 F2 0B 46 A1 DF 56 60 D4 5C 76 4B 52 19 DA 83';
$cv = '65 65 76 65 72 20 79 6F 75 20 6D 61 79 20 62 65';

$c1_array = array_map('hexdec', explode(' ', $c1));
$cv_array = array_map('hexdec', explode(' ', $cv));

$m1 = array();
foreach ($c1_array as $i => $byte) {
    $m1[] = $byte ^ $cv_array[$i];
}

print("m[1] = [" . count($m1) . "] ");
foreach ($m1 as $byte) {
    printf("%02X ", $byte);
}

?>