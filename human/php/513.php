<?php

function Decrypt($c) {
    return hex2bin($c);
}

$c = array("45616E6365207468656E2C2077686572");
$CV = "70 76 12 58 4E 38 1C E1 92 CA 34 FB 9A 37 C5 0A";

$m = array();
$m[0] = Decrypt($c[0]) ^ hex2bin(str_replace(" ", "", $CV));

$nextCV = str_replace(" ", "", bin2hex($m[0]));

print("Decrypt(c[0]) = [" . strlen($c[0]) / 2 . "] " . strtoupper(bin2hex(Decrypt($c[0]))) . "\n");
print("m[0] := Decrypt(c[0]) XOR CV = [" . strlen($c[0]) / 2 . "] " . strtoupper(bin2hex($m[0])) . "\n");
print("Next CV := c[0] = [" . strlen($c[0]) / 2 . "] " . strtoupper($nextCV) . "\n");

?>