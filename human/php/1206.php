<?php
function rotate_left($x, $c) {
    return ($x << $c) | ($x >> (32 - $c));
}

// Test the function
$x = 0x12345678;
$c = 4;
echo dechex(rotate_left($x, $c));
?>