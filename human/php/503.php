<?php

$IV = hex2bin("01000000000000000000000000000000");
$c = array(
    hex2bin("175CC097FFEF635A88836C0062BF87E5"),
    hex2bin("1D66DB972E2C")
);

print "IV: " . bin2hex($IV) . "\n";
print "c[0]: " . bin2hex($c[0]) . "\n";
print "c[1]: " . bin2hex($c[1]) . "\n";

?>